# eclipseの設定

1. ウィンドウ > 設定
	* XML > XMLファイル > エディタ
		* 行の幅
	* Java > コード・スタイル > フォーマッター
		* アクティブなプロファイルの編集
			* インデント
				* タブ・ポリシー：スペースのみ
			* 行折り返し
				* 行の最大値：9999

	* [任意]一般 > キー
		* コマンドが呼び出されたときにキー・バインドを表示する：すべてオフ
2. 実行時の引数
	* プロジェクトを右クリック > 実行 > 実行の構成
		* 引数タブ > VM引数に `-Dspring.profiles.active=dev`を設定する


# H2DB
* see :[Spring BootでH2 Database Engineを使用する](https://zenn.dev/developma/articles/548b9652b01131)
* アプリ起動
	* [http://localhost:8080/h2-console/](http://localhost:8080/h2-console/)
		* application.propertiesで設定した値を入力して接続
			* JDBC URL：jdbc:h2:mem:testdb;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
			* username：sa
			* password:

## memo
commonDataの保存と取得  
CommonLoggingAspectのbefore  
```
// 最後に実行したメソッドのCommonDataを保持する
CommonData commonData = JoinPointUtility.getCommonDataFromArgs(joinPoint);
if (commonData != null) {
    RequestContextHolder.currentRequestAttributes().setAttribute(Const.LAST_METHOD_COMMON_DATA, commonData, RequestAttributes.SCOPE_REQUEST);
}
```

ErrorHandlerApiで  
```
// 最後に実行したメソッドのCommonDataを取得する
        CommonData lastCommonData = (CommonData) RequestContextHolder.currentRequestAttributes().getAttribute(Const.LAST_METHOD_COMMON_DATA, RequestAttributes.SCOPE_REQUEST);
```

ファイルが下記の順番だとうまくいく。
@Orderでもうまく効かなかった。
Controllerが、RestControllerも含んでいる影響？？
```
ErrorHandlerApi
ErrorHandlerView
```
