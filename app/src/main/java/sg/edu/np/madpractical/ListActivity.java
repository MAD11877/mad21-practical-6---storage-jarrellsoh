package sg.edu.np.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    static ArrayList<User> userdata = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

//        ImageView image = findViewById(R.id.ListImage);
//        image.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                showAlertDialog(v);
//            }
//        });

        for(int i = 0; i<20; i++){
            int nameInt = new Random().nextInt();
            int descriptionInt = new Random().nextInt();
            boolean followedBool = new Random().nextBoolean();
            User user = new User();
            user.setName("Name-" + nameInt);
            user.setDescription("Description-" + descriptionInt);
            user.setId(i);
            user.setFollowed(followedBool);
            userdata.add(user);
        }

        RecyclerView rv = findViewById(R.id.rv);
        UserAdapter adapter = new UserAdapter(this, userdata);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }
//    public void showAlertDialog(View v){
//        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//        alert.setTitle("Profile");
//        alert.setMessage("MADness");
//        alert.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        alert.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent toMain = new Intent(ListActivity.this, MainActivity.class);
//                Random id = new Random();
//                toMain.putExtra("id", String.valueOf(id.nextInt()));
//                startActivity(toMain);
//            }
//        });
//        alert.create().show();
//    }
}