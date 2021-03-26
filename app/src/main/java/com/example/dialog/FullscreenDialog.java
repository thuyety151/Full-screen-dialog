package com.example.dialog;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.dialog.R;

public class FullscreenDialog extends DialogFragment implements View.OnClickListener {

    private Callback callback;

    static FullscreenDialog newInstance() {
        return new FullscreenDialog();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set style.FullscreenDialogTheme at styles.xml
        setStyle(DialogFragment.STYLE_NORMAL,R.style.FullscreenDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //create view
        View view = inflater.inflate(R.layout.fullscreen_dialog, container, false);

        // button close dialog, create onClickListener of imagebutton action
        ImageButton close = view.findViewById(R.id.fullscreen_dialog_close);
        close.setOnClickListener(this);

        // action save, create onClickListener of textview action
        TextView action = view.findViewById(R.id.fullscreen_dialog_action);
        action.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            // click  close button
            case R.id.fullscreen_dialog_close:
                dismiss();
                break;

                //click save
            case R.id.fullscreen_dialog_action:

                callback.onActionClick("Whatever");
                dismiss();
                break;

        }

    }

    public interface Callback {

        void onActionClick(String name);

    }

}