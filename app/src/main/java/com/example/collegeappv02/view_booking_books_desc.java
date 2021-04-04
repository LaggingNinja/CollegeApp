package com.example.collegeappv02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class view_booking_books_desc extends AppCompatActivity {

    ImageView mainImageView;
    TextView title, description, item_book_pagesrev, words;
    String data1, data2, data3;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booking_books_desc);

        words = (TextView) findViewById(R.id.words);
        String para = "A NEW YORK TIMES AND WASHINGTON POST NOTABLE BOOK\n" +
                "A 2018 BEST OF THE YEAR SELECTION OF NPR * TIME * BUSTLE * O, THE OPRAH MAGAZINE * THE DALLAS MORNING NEWS * AMAZON.COM\n" +
                "OPRAH’S BOOK CLUB 2018 SELECTION\n" +
                "WINNER OF THE WOMEN'S PRIZE FOR FICTION\n" +
                "WINNER OF THE 2019 ASPEN WORDS LITERARY PRIZE\n" +
                "WINNER OF THE 2019 NAACP IMAGE AWARD FOR OUTSTANDING LITERARY WORK—FICTION\n" +
                "LONGLISTED FOR THE 2018 NATIONAL BOOK AWARD FOR FICTION\n" +
                "\n" +
                "“A moving portrayal of the effects of a wrongful conviction on a young African-American couple.” —Barack Obama\n" +
                "“Haunting . . . Beautifully written.” —The New York Times Book Review\n" +
                "“Brilliant and heartbreaking . . . Unforgettable.” —USA Today\n" +
                "“A tense and timely love story . . . Packed with brave questions about race and class.” —People\n" +
                "“Compelling.” —The Washington Post\n" +
                "“Deeply moving . . . thought-provoking.\" —Bill Gates\n" +
                "“Epic . . . Transcendent . . . Triumphant.” —Elle\n" +
                "\n" +
                "Newlyweds Celestial and Roy are the embodiment of both the American Dream and the New South. He is a young executive, and she is an artist on the brink of an exciting career. But as they settle into the routine of their life together, they are ripped apart by circumstances neither could have imagined. Roy is arrested and sentenced to twelve years for a crime Celestial knows he didn’t commit. Though fiercely independent, Celestial finds herself bereft and unmoored, taking comfort in Andre, her childhood friend, and best man at their wedding. As Roy’s time in prison passes, she is unable to hold on to the love that has been her center. After five years, Roy’s conviction is suddenly overturned, and he returns to Atlanta ready to resume their life together.\n" +
                "\n" +
                "This stirring love story is a profoundly insightful look into the hearts and minds of three people who are at once bound and separated by forces beyond their control. An American Marriage is a masterpiece of storytelling, an intimate look deep into the souls of people who must reckon with the past while moving forward—with hope and pain—into the future.";
        words.setText(para);
        words.setMovementMethod(new ScrollingMovementMethod());

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        item_book_pagesrev = findViewById(R.id.item_book_pagesrev);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") &&
                getIntent().hasExtra("data2") && getIntent().hasExtra("data3")){

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
            myImage = getIntent().getIntExtra("myImage", 1);

        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title.setText(data1);
        description.setText(data2);
        item_book_pagesrev.setText(data3);
        mainImageView.setImageResource(myImage);

    }

}