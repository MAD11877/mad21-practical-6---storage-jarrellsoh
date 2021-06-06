package sg.edu.np.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent in = getIntent();
        int id = in.getIntExtra("id", 0);
        User user = ListActivity.userdata.get(id);
        TextView mainName = findViewById(R.id.MainName);
        TextView mainDescription = findViewById(R.id.MainDescription);
        mainName.setText(user.getName());
        mainDescription.setText(user.getDescription());
        Button fButton = findViewById(R.id.MainFollow);
        if (user.isFollowed()){
            fButton.setText("Unfollow");
        }
        else{
            fButton.setText("Follow");
        }
        fButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (user.isFollowed()){
                    fButton.setText("Follow");
                    user.setFollowed(false);
                    Toast followedtoast = Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT);
                    followedtoast.show();
                }
                else{
                    fButton.setText("Unfollow");
                    user.setFollowed(true);
                    Toast unfollowedtoast = Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT);
                    unfollowedtoast.show();
                }
                DBHandler db = new DBHandler(getApplicationContext());
                db.updateUser(user);
            }
        });
    }
}