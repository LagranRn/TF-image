# TF-image

## 2018.7.14 zjs 增加线程池获取数据帧
*修改第一次的项目结构，增加一个IView接口*
1.增加一个BaseApp用户全局获取Context

##2018.7.1  zjs  项目整改
利用mvp模式对项目进行了整改，
主要修改如下：
1.将跟activity无关的识别图片放到Presenter里面，Presenter主要用来处理业务逻辑
2.activity提供一个显示结果的接口public void showResult(String text);
3.将与activity无关的bitmap裁剪功能提出来放到utils/BitmapUtils里面
4.布局文件的空间id统一了一下命名格式
5.利用AsyncTask来处理图片


## kong1337
使用camera2相机功能，并用TextureView输出到屏幕上。
使用tensorflow训练的模型，一个是28*28的1到0的识别数字的模型。
另一个是识别物体的模型。
使用音量键就可以照相，并将识别的信息输出到屏幕下方。
