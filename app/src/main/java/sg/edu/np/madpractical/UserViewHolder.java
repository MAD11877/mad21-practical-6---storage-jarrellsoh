package sg.edu.np.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView userImage;
    TextView userName;
    TextView userDescription;
    ImageView bigImage;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userImage = itemView.findViewById(R.id.UserImage);
        userName = itemView.findViewById(R.id.UserName);
        userDescription = itemView.findViewById(R.id.UserDescription);
        bigImage = itemView.findViewById(R.id.BigImage);
    }
}