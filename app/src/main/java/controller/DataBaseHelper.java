package controller;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import constants.Const;
import model.Data;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context) {
        super(context , Const.DATABASE_NAME , null , Const.DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String myTable = "CREATE TABLE " + Const.TABLE_NAME + " (" +
                Const.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Const.COLUMN_FIYAT + " TEXT," + Const.COLUMN_FATURA_NO + " TEXT," + Const.COLUMN_SOZLESME_NO + " TEXT,"
                + Const.COLUMN_TIME_STAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP" + " );" ;
        db.execSQL(myTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Const.TABLE_NAME);
        onCreate(db);
    }

    //Insert (long function) DATA ( Add DATA Function )
    public long addData(Data data) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put( Const.COLUMN_FIYAT , data.getFiyat() );
        cv.put( Const.COLUMN_FATURA_NO , data.getFaturaNo() );
        cv.put( Const.COLUMN_SOZLESME_NO , data.getSozlesmeNo() );
        long insData = database.insert(Const.TABLE_NAME , null , cv);
        database.close();
        return insData;
    }

    //Get Data ( USING Cursor With ID !!! / RETURN DATA )
    public Data getData(int id) {
        SQLiteDatabase database = this.getReadableDatabase();

        String arr1[] = { Const.COLUMN_ID , Const.COLUMN_FIYAT ,Const.COLUMN_FATURA_NO ,Const.COLUMN_SOZLESME_NO , Const.COLUMN_TIME_STAMP };
        String arr2[] = { String.valueOf(id) } ;

        Cursor cursor = database.query( Const.TABLE_NAME , arr1 , Const.COLUMN_ID + "=?"
                                        , arr2 , null , null , null , null );

        if( cursor != null )
            cursor.moveToFirst();

        Data data = new Data( Integer.parseInt(cursor.getString(0)) , cursor.getString(1),
                            cursor.getString(2) , cursor.getString(3) , cursor.getString(4) );

        database.close();
        cursor.close();
        return data;
    }

    // Update DATA FUNCTION / EDIT DATA ( RETURN INT (update func. return int))
    public int updateData(Data data) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put( Const.COLUMN_FIYAT , data.getFiyat() );
        cv.put( Const.COLUMN_FATURA_NO , data.getFaturaNo() );
        cv.put( Const.COLUMN_SOZLESME_NO , data.getSozlesmeNo() );
        String arr2[] = { String.valueOf(data.getId()) } ;
        int upDateFunc = database.update(Const.TABLE_NAME , cv , Const.COLUMN_ID + "=?" , arr2);
        database.close();
        return upDateFunc;
    }

    // Delete DATA FUNCTION / ( ONLY VOID WITHOUT RETURN )
    public void deleteData(Data data) {
        SQLiteDatabase database = this.getWritableDatabase();
        String arr2[] = { String.valueOf(data.getId()) } ;
        database.delete(Const.TABLE_NAME , Const.COLUMN_ID + "=?" , arr2 );
        database.close();
    }

    //Get ALL Data ( USING Cursor !!! / RETURN DATA )
    @SuppressLint("Range")
    public List<Data> getAllData() {
        SQLiteDatabase database = this.getReadableDatabase();
        List<Data> dataList = new ArrayList<>();

        String query = "SELECT * FROM " + Const.TABLE_NAME +
                " ORDER BY " + Const.COLUMN_TIME_STAMP + " DESC ";

        Cursor cursor = database.rawQuery(query , null);

        if( cursor.moveToFirst() ) {
            do {
                Data data = new Data();
                data.setId( cursor.getInt( cursor.getColumnIndex(Const.COLUMN_ID) ));
                data.setFiyat( cursor.getString( cursor.getColumnIndex(Const.COLUMN_FIYAT) ) );
                data.setFaturaNo( cursor.getString( cursor.getColumnIndex(Const.COLUMN_FATURA_NO) ) );
                data.setSozlesmeNo( cursor.getString( cursor.getColumnIndex(Const.COLUMN_SOZLESME_NO) ) );
                data.setTimeStamp( cursor.getString( cursor.getColumnIndex(Const.COLUMN_TIME_STAMP) ) );
                dataList.add(data);
            }
            while ( cursor.moveToNext() ) ;
        }

        database.close();
        cursor.close();
        return dataList;
    }

    public int countData() {
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + Const.TABLE_NAME;
        Cursor cursor = database.rawQuery(query , null);
        int c = cursor.getCount();
        return c;
    }
}