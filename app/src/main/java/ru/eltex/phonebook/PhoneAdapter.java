package ru.eltex.phonebook;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PhoneAdapter extends ArrayAdapter<User> {

    private Context context;
    private List<User> users;

    PhoneAdapter(Context context, List<User> users){
        super(context,R.layout.item, users);
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item, parent, false);

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(this.users.get(position).getName());

        TextView phone = (TextView) view.findViewById(R.id.phone);
        phone.setText(this.users.get(position).getPhone());

        ImageView imageView = (ImageView) view.findViewById(R.id.avatar);

        if(this.users.get(position) instanceof Developer) {
            if(this.users.get(position).getGenderMen()) {
                imageView.setImageResource(R.drawable.developer_man);
            }else imageView.setImageResource(R.drawable.developer_woman);
        }else if(this.users.get(position) instanceof Manager){
            if(this.users.get(position).getGenderMen()) {
                imageView.setImageResource(R.drawable.manager_man);
            }else imageView.setImageResource(R.drawable.manager_woman);
        }else imageView.setImageResource(R.drawable.ic_launcher_foreground);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, users[position].getGender(), Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}
