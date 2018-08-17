package com.hamsoftug.numerickeyboard;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Nk_board extends Fragment {

    public interface OnKeyBoard {
        void onOnDeletePressed(View v);
        void onKeyPressed(int value);
        void onOkPressed(View v);
    }

    private OnKeyBoard listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_nk_board, container, false);

        rootView.findViewById(R.id.one_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeValue("1");
            }
        });
        rootView.findViewById(R.id.two_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeValue("2");
            }
        });
        rootView.findViewById(R.id.three_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeValue("3");
            }
        });
        rootView.findViewById(R.id.four_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeValue("4");
            }
        });
        rootView.findViewById(R.id.five_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeValue("5");
            }
        });
        rootView.findViewById(R.id.six_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeValue("6");
            }
        });
        rootView.findViewById(R.id.seven_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeValue("7");
            }
        });
        rootView.findViewById(R.id.eight_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeValue("8");
            }
        });
        rootView.findViewById(R.id.nine_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeValue("9");
            }
        });
        rootView.findViewById(R.id.zero_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeValue("0");
            }
        });
        rootView.findViewById(R.id.delete_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onOnDeletePressed(v);
            }
        });

        rootView.findViewById(R.id.ok_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onOkPressed(view);
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (OnKeyBoard) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.getClass().getName() + " must implement "
                    + OnKeyBoard.class);
        }

    }

    private void takeValue(String num) {
        listener.onKeyPressed(Integer.parseInt(num));
    }

}
