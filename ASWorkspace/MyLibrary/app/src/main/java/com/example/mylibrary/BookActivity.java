package com.example.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    
    private static final String TAG = "BookActivity";

    private TextView bookName, authorName, description, pageNumber;
    private ImageView bookImage;
    private Button btnCurReading, btnWantToRead, btnAlreadyRead;

    private Book incomingBook;
    private Util util;

    private boolean doesExist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        overridePendingTransition(R.anim.in, R.anim.out);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();
        Intent intent = getIntent();
        int id = intent.getIntExtra("bookId", 0);
        util = new Util();
        ArrayList<Book> books = util.getAllBooks();

        for(Book b: books) {
            if(b.getId() == id) {
                incomingBook = b;
                bookName.setText(b.getName());
                authorName.setText(b.getAuthor());
                description.setText(b.getDescription());
                pageNumber.setText("Pages: " + b.getPages());
                Glide.with(this)
                        .asBitmap()
                        .load(b.getImageUrl())
                        .into(bookImage);
            }
        }

        btnCurReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCurReadingTapped();
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlreadyReadTapped();
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWantToReadTapped();
            }
        });
    }

    private void btnWantToReadTapped() {

        Log.d(TAG, "btnWantToReadTapped: started");

        ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();

        if (wantToReadBooks.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You Already Added This Book to Your Want To Read List");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setCancelable(true);
            builder.create().show();
        } else {
            ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();

            if(alreadyReadBooks.contains(incomingBook)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You already reading this book");
                builder.setTitle("Error");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            } else {
                ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();

                if(currentlyReadingBooks.contains(incomingBook)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("You already read this book");
                    builder.setTitle("Error");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();
                } else {
                    util.addWantToReadBooks(incomingBook);
                    Toast.makeText(this, "The Book " + incomingBook.getName() + " Added to your Want To Read Shelf", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void btnAlreadyReadTapped() {
        Log.d(TAG, "btnAlreadyReadTapped: started");

        ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();

        if (alreadyReadBooks.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Have You Finished Reading This Book?");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    util.removeCurrentlyReadingBooks(incomingBook);
                    util.addAlreadyReadBooks(incomingBook);
                    Toast.makeText(BookActivity.this, "The Book " + incomingBook.getName() + " Added to your Already Read Shelf", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setCancelable(true);
            builder.create().show();
        } else {
            ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();

            if(currentlyReadingBooks.contains(incomingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You already read this book");
                builder.setTitle("Error");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            } else {
                util.addAlreadyReadBooks(incomingBook);
                Toast.makeText(this, "The Book " + incomingBook.getName() + " Added to your Already Read Shelf", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void btnCurReadingTapped() {
        Log.d(TAG, "btnCurReadingTapped: started");

        ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();

        if(currentlyReadingBooks.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You Already Added This Book to Your Currently Reading List");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setCancelable(true);
            builder.create().show();
        } else {
            ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();

            if(wantToReadBooks.contains(incomingBook)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are You Going To Start Reading This Book?");
                builder.setTitle("Error");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removeWantToReadBooks(incomingBook);
                        util.addCurrentlyReadingBook(incomingBook);
                        Toast.makeText(BookActivity.this, "The Book " + incomingBook.getName() + " Added to your Current Reading Shelf", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            } else {
                ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();

                if(alreadyReadBooks.contains(incomingBook)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Do You Want To Read This Book Again?");
                    builder.setTitle("Error");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            util.addCurrentlyReadingBook(incomingBook);
                            Toast.makeText(BookActivity.this, "The Book " + incomingBook.getName() + " Added to your Current Reading Shelf", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();
                } else {
                    util.addCurrentlyReadingBook(incomingBook);
                    Toast.makeText(this, "The Book " + incomingBook.getName() + " Added to your Current Reading Shelf", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void initWidgets() {
        bookName = (TextView) findViewById(R.id.bookName);
        authorName = (TextView) findViewById(R.id.authorName);
        description = (TextView) findViewById(R.id.bookDesc);
        pageNumber = (TextView) findViewById(R.id.bookPage);

        bookImage = (ImageView) findViewById(R.id.bookImage);

        btnCurReading = (Button) findViewById(R.id.btnCurReading);
        btnWantToRead = (Button) findViewById(R.id.btnWantToRead);
        btnAlreadyRead = (Button) findViewById(R.id.btnAlreadyRead);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
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
