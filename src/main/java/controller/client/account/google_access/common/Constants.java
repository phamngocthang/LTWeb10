package controller.client.account.google_access.common;
public class Constants {
  public static String GOOGLE_CLIENT_ID = "998202632275-0a5fp9m07oq440p1c6bec8g3t47itono.apps.googleusercontent.com";
  public static String GOOGLE_CLIENT_SECRET = "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";
  //public static String GOOGLE_REDIRECT_URI = "http://localhost:8999/WebApp/login-google";
  public static String GOOGLE_REDIRECT_URI = "https://nhom10-app.herokuapp.com/login-google";
  public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
  public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
  public static String GOOGLE_GRANT_TYPE = "authorization_code";
}