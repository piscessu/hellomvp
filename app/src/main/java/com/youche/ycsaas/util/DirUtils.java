package com.youche.ycsaas.util;

import android.os.Environment;
import android.widget.Toast;

import com.youche.ycsaas.app.App;

import java.io.File;

public class DirUtils {

    public static File filePhoto;
    public static File fileYouche;
    public static File fileDatabase;
    public static File fileCache;
    public static File fileLog;
    public static File fileImageCache;

    public static String pathYouche;
    public static String pathPhoto;
    public static String pathDatabase;
    public static String pathCache;
    public static String pathLog;
    public static String pathImageCache;


    static {
        initDirs();
    }

    private static File getStoreDir() {
        File dir = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            dir = Environment.getExternalStorageDirectory();
        } else {
            dir = App.getAppContext().getDir("tmp", App.MODE_PRIVATE);
        }

        return dir;
    }


    /**
     * 初始化存储目录，创建所需要的目录
     */
    public static void initDirs() {
        File dir = getStoreDir();
        if (dir == null || !dir.canWrite()) {
            Toast.makeText(App.getAppContext(), "没有找到存储设备", Toast.LENGTH_LONG).show();
            return;
        }
        fileYouche = new File(dir, App.getAppContext().getPackageName());
        filePhoto = new File(fileYouche, "/photo/");
        fileDatabase = new File(fileYouche, "/databases/");
        fileCache = new File(fileYouche, "/cache/");
        fileLog = new File(fileYouche, "/log/");
        fileImageCache = new File(fileYouche, "/imageCache/");

        if (!fileYouche.exists()) {
            fileYouche.mkdirs();
        }
        if (!filePhoto.exists()) {
            filePhoto.mkdirs();
        }
        File nomedia = new File(filePhoto, ".nomedia");
        try {
            nomedia.createNewFile();
        } catch (Exception e) {
        }
        if (!fileDatabase.exists()) {
            fileDatabase.mkdirs();
        }
        if (!fileCache.exists()) {
            fileCache.mkdirs();
        }
        if (!fileLog.exists()) {
            fileLog.mkdirs();
        }
        if (!fileImageCache.exists()) {
            fileImageCache.mkdirs();
        }

        pathDatabase = fileDatabase.getAbsolutePath() + "/";
        pathPhoto = filePhoto.getAbsolutePath() + "/";
        pathCache = fileCache.getAbsolutePath() + "/";
        pathLog = fileLog.getAbsolutePath() + "/";
        pathYouche = fileYouche.getAbsolutePath() + "/";
        pathImageCache = fileImageCache.getAbsolutePath() + "/";
    }


}
