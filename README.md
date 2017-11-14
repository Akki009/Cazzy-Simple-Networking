# Cazzy-Simple-Networking

[![](https://jitpack.io/v/bhavin250495/Cazzy-Simple-Networking.svg)](https://jitpack.io/#bhavin250495/Cazzy-Simple-Networking)


#### Add repositories in build.gradle (Project:YOUR_APP_NAME)

  ```javascript
  repositories {
        jcenter()
        maven { url 'https://jitpack.io' }
    }
  ```
  
  #### Add dependencies in build.gradle (Module:app)

  ```javascript
  dependencies {
  
  //... other dependencies
  
  compile 'com.github.bhavin250495:Cazzy-Simple-Networking:1.0'
  
  }
  ```
  
  ## Usage
  
  
   ### HTTP GET REQUEST
  
  ```javascript 
  
     Http_request.sendGetRequest("url", new ResponseHandler() {
                                @Override
                                public void getResponse(ServerResponseWrapper serverResponseWrapper) {
                                    if (serverResponseWrapper.isSuccess){
                                        Log.d("TAG",serverResponseWrapper.response);
                                    }else{
                                        Log.d("TAG",serverResponseWrapper.response);
                                    }
                                }
                            });
  
  ```
  
  
  
  ### HTTP **POST** REQUEST
  
  ```javascript 
  
     Http_request.sendPostRequest("url", JsonParam.toString(), new ResponseHandler() {
                                @Override
                                public void getResponse(ServerResponseWrapper serverResponseWrapper) {
                                    if (serverResponseWrapper.isSuccess){
                                        Log.d("TAG",serverResponseWrapper.response);
                                    }else{
                                        Log.d("TAG",serverResponseWrapper.response);
                                    }
                                }
                            });
  
  ```
  
 
  
  
  
  
