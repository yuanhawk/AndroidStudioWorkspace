package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SeeAllBooksActivity extends AppCompatActivity {

    //defining logtag
    private static final String TAG = "SeeAllBooksActivity";

    private RecyclerView booksRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_books);

        overridePendingTransition(R.anim.in, R.anim.out);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d(TAG, "onCreate: started");
        //use loge for details of some errors

        booksRecyclerView = (RecyclerView) findViewById(R.id.booksRecyclerView);
        BooksRecViewAdapter adapter = new BooksRecViewAdapter(this);
        booksRecyclerView.setAdapter(adapter);
        //How we want to order our items in our recyclerView
        booksRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        Util util = new Util();
        ArrayList<Book> books = new ArrayList<>();
        books = util.getAllBooks();
        adapter.setBooks(books);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}
