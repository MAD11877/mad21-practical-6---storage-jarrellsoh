package sg.edu.np.madpractical;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    Context context;
    ArrayList<User> userdata;

    public UserAdapter(Context c, ArrayList<User> d){
        context = c;
        userdata = d;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_user, parent, false);

        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userdata.get(position);
        holder.userName.setText(user.getName());
        holder.userDescription.setText(user.getDescription());

        if(user.getName().endsWith("7")){
            holder.bigImage.setVisibility(View.VISIBLE);
        }
        else{
            holder.bigImage.setVisibility(View.GONE);
        }

        holder.userImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder alert = new AlertDialog.Builder(holder.userImage.getContext());
                alert.setTitle("Profile");
                alert.setMessage(user.getName());
                alert.setNegativeButton("Close", null);
                alert.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent toMain = new Intent(holder.userImage.getContext(), MainActivity.class);
                        toMain.putExtra("id", position);
                        holder.userImage.getContext().startActivity(toMain);
                    }
                });
                alert.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userdata.size();
    }
}

