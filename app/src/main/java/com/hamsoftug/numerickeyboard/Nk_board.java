package com.hamsoftug.numerickeyboard;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Nk_board extends Fragment {

    private static final int DELAY = 500;

    private TextView pass1;
    private TextView pass2;
    private TextView pass3;
    private TextView pass4;

    private int length = 0;

    public interface OnKeyBoard {
        void onPasscodeEntered(String pass);
        void onOnDeletePressed();
        void onKeyPressed(int value);
    }

    private OnKeyBoard listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_nk_board, container, false);

        pass1 = rootView.findViewById(R.id.passcode1);
        pass2 = rootView.findViewById(R.id.passcode2);
        pass3 = rootView.findViewById(R.id.passcode3);
        pass4 = rootView.findViewById(R.id.passcode4);

        rootView.findViewById(R.id.one_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("1");
            }
        });
        rootView.findViewById(R.id.two_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("2");
            }
        });
        rootView.findViewById(R.id.three_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("3");
            }
        });
        rootView.findViewById(R.id.four_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("4");
            }
        });
        rootView.findViewById(R.id.five_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("5");
            }
        });
        rootView.findViewById(R.id.six_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("6");
            }
        });
        rootView.findViewById(R.id.seven_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("7");
            }
        });
        rootView.findViewById(R.id.eight_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("8");
            }
        });
        rootView.findViewById(R.id.nine_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("9");
            }
        });
        rootView.findViewById(R.id.zero_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("0");
            }
        });
        rootView.findViewById(R.id.delete_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (length) {
                    case 1:
                        pass1.setText(null);
                        length--;
                        break;
                    case 2:
                        pass2.setText(null);
                        length--;
                        break;
                    case 3:
                        pass3.setText(null);
                        length--;
                        break;
                    case 4:
                        pass4.setText(null);
                        length--;
                }
                listener.onOnDeletePressed();
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnKeyBoard) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement "
                    + OnKeyBoard.class);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (OnKeyBoard) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement "
                    + OnKeyBoard.class);
        }

    }

    private void add(String num) {
        listener.onKeyPressed(Integer.parseInt(num));
        switch (length + 1) {
            case 1:
                pass1.setText(num);
                length++;
                break;
            case 2:
                pass2.setText(num);
                length++;
                break;
            case 3:
                pass3.setText(num);
                length++;
                break;
            case 4:
                pass4.setText(num);
                length++;

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        listener.onPasscodeEntered(pass1.getText().toString() + pass2.getText()
                                + pass3.getText() + pass4.getText());
                        pass1.setText(null);
                        pass2.setText(null);
                        pass3.setText(null);
                        pass4.setText(null);
                        length = 0;
                    }
                }, DELAY);
        }
    }

}
