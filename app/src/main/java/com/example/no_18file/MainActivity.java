package com.example.no_18file;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    protected  final  String MyFileName="data.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonW=(Button)findViewById(R.id.botton_write);
        buttonW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutputStream out=null;
                try{
                    FileOutputStream fileOutputStream=openFileOutput(MyFileName,MODE_PRIVATE);
                    out=new BufferedOutputStream(fileOutputStream);
                    String content="fanguangsheng,2017011223";
                    try{
                        out.write(content.getBytes(StandardCharsets.UTF_8));
                    }finally {
                        if(out!=null) {
                            out.close();
                            Toast.makeText(MainActivity.this,content+" 已经成功写入！！",Toast.LENGTH_SHORT).show();
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        Button buttonR=(Button)findViewById(R.id.button_read);
        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputStream input=null;
                try{
                    FileInputStream fileInputStream=openFileInput(MyFileName);
                    input=new BufferedInputStream(fileInputStream);
                    int c;
                    StringBuffer stringBuffer=new StringBuffer("");
                    try{
                        while((c=input.read())!=-1){
                            stringBuffer.append((char)c);
                        }
                        Toast.makeText(MainActivity.this,stringBuffer.toString(),Toast.LENGTH_SHORT).show();

                    }finally {
                        if(input!=null)
                            input.close();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
