package spluslat.resolver;

import java.util.UUID;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import spluslat.data.CommonData;

@Component
public class CommonDataArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // CommonData クラスの引数のみをサポートする
        return CommonData.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception {

        // リクエストから共通情報を取得するロジックを記述
        // 例: ヘッダーやクエリパラメータから情報を取得
        CommonData commonInfo = new CommonData();
        commonInfo.setUuid(UUID.randomUUID().toString());
        commonInfo.setCustom1(webRequest.getHeader("Host"));
        commonInfo.setCustom2(2);
        commonInfo.setCustom3(false);
        commonInfo.setCustom4(4);
        commonInfo.setCustom5(null);
        return commonInfo;
    }
}
