package com.example.armada.networktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView responseText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendRequest = (Button)findViewById(R.id.send_request);
        responseText = (TextView)findViewById(R.id.response_text);
        sendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_request) {
            //sendRequestWithHttpURLConnection();
            sendRequestWithOkHttp();
        }
    }

    private void sendRequestWithHttpURLConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("https://www.baidu.com");
                    connection = (HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    // 下面对获取的输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    showResponse(response.toString());
                }catch(Exception e) {
                    e.printStackTrace();
                }finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private void sendRequestWithHttpUtil() {
        String address = "https://www.sojson.com/open/api/weather/json.shtml?city=%E5%8C%97%E4%BA%AC";
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                // 在这里根据返回内容进行具体的逻辑
            }

            @Override
            public void onError(Exception e) {
                // 在这里对异常情况进行处理
            }
        });

        HttpUtil.sendOkHttpRequest(address, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 在这里对异常情况进行处理
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 得到服务器返回的具体内容
            }
        });
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            //.url("https://www.baidu.com")
                            // XML解析
                            //.url("http://www.w3school.com.cn/example/xmle/note.xml")
                            // JSON解析
                            .url("https://www.sojson.com/open/api/weather/json.shtml?city=%E5%8C%97%E4%BA%AC")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    //showResponse(responseData);
                    // XMLPull
                    //parseXMLWithPull(responseData);
                    //SAX
                    //parseXMLWithSAX(responseData);
                    // JSON
                    //parseJSONWithJSONObject(responseData);
                    parseJSONWithGSON(responseData);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseXMLWithPull(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType = xmlPullParser.getEventType();
            String to = "";
            String from = "";
            String heading = "";
            String body = "";

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch(eventType) {
                    // 开始解析某个节点
                    case XmlPullParser.START_TAG: {
                        if ("to".equals(nodeName)) {
                            to = xmlPullParser.nextText();
                        }else if ("from".equals(nodeName)) {
                            from = xmlPullParser.nextText();
                        }else if ("heading".equals(nodeName)) {
                            heading = xmlPullParser.nextText();
                        }else if ("body".equals(nodeName)) {
                            body = xmlPullParser.nextText();
                        }
                        break;
                    }

                    case XmlPullParser.END_TAG: {
                        if ("note".equals(nodeName)) {
                            Log.d("MainActivity", "from "+from);
                            Log.d("MainActivity","to "+to);
                            Log.d("MainActivity", "heading "+heading);
                            Log.d("MainActivity", "body "+body);
                        }
                        break;
                    }
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseXMLWithSAX(String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            ContentHandler handler = new ContentHandler();
            // 将ContentHandler的实例设置到XMLReader中
            xmlReader.setContentHandler(handler);
            //开始执行解析
            xmlReader.parse(new InputSource((new StringReader(xmlData))));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseJSONWithJSONObject(String jsonData) {
        try {
            JSONObject json = new JSONObject(jsonData);
            JSONObject data = json.getJSONObject("data");
            JSONArray forecast = data.getJSONArray("forecast");

            for(int i = 0; i < forecast.length(); i++) {
                JSONObject jsonObject = forecast.getJSONObject(i);
                String date = jsonObject.getString("date");
                String sunrise = jsonObject.getString("sunrise");
                String high = jsonObject.getString("high");
                String low = jsonObject.getString("low");
                String aqi = jsonObject.getString("aqi");
                String fx = jsonObject.getString("fx");
                String fl = jsonObject.getString("fl");
                String type = jsonObject.getString("type");
                String notice = jsonObject.getString("notice");

                Log.d("MainActivity","date is "+date);
                Log.d("MainActivity","sunrise is "+sunrise);
                Log.d("MainActivity","high is "+high);
                Log.d("MainActivity","low is "+low);
                Log.d("MainActivity","aqi is "+aqi);
                Log.d("MainActivity","fx is "+fx);
                Log.d("MainActivity","fl is "+fl);
                Log.d("MainActivity","type is "+type);
                Log.d("MainActivity","notice is "+notice);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseJSONWithGSON(String jsonData) {
        try {

            Gson gson = new Gson();
            List<Weather> weathers = gson.fromJson(jsonData, JSONResult.class).getData().getForecast();
            for (Weather weather:weathers) {
                Log.d("MainActivity","date is "+weather.getDate());
                Log.d("MainActivity","sunrise is "+weather.getSunrise());
                Log.d("MainActivity","high is "+weather.getHigh());
                Log.d("MainActivity","low is "+weather.getLow());
                Log.d("MainActivity","aqi is "+weather.getAqi());
                Log.d("MainActivity","fx is "+weather.getFx());
                Log.d("MainActivity","fl is "+weather.getFl());
                Log.d("MainActivity","type is "+weather.getType());
                Log.d("MainActivity","notice is "+weather.getNotice());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行UI操作， 将结果显示到界面上
                responseText.setText(response);
            }
        });
    }
}
