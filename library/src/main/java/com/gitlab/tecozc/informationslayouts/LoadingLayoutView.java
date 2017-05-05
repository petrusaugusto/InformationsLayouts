package com.gitlab.tecozc.informationslayouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.petrusaugusto.library.R;


/**
 * Created by Petrus A. (R@G3), ESPE... On 04/03/2017.
 */

public class LoadingLayoutView extends LinearLayout {
    protected String defaultLoadingTextessage;
    protected ProgressBar loadingView;
    protected TextView loadingTextView;

    public LoadingLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.InitializeViewElements(context);

        // Definindo atributos via XML
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LoadingLayoutView, 0, 0);
        try {
            this.setLoadingText(a.getString(R.styleable.LoadingLayoutView_loadingText));
            if ( !a.getBoolean(R.styleable.LoadingLayoutView_showLoadingIcon, true) ) this.loadingView.setVisibility(GONE);
        } finally {
            a.recycle();
        }
    }

    public LoadingLayoutView(Context context) {
        super(context);
        this.InitializeViewElements(context);
    }

    private void InitializeViewElements(Context context) {
        // 0 -> Definindo o texto padrão
        this.defaultLoadingTextessage = context.getString(R.string.informations_layouts_default_loading_text);

        // 1 -> Inicializando elementos filhos
        // Criando elementos de imagens/icones
        loadingView = new ProgressBar(context);
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
        loadingView.setLayoutParams(new ViewGroup.LayoutParams(width, height));

        // Criando os elementos de texto
        loadingTextView = new TextView(context);
        loadingTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        loadingTextView.setText(defaultLoadingTextessage);

        // 2 -> Definindo os parametros padrao do elemento
        this.setGravity(Gravity.CENTER);
        this.setOrientation(VERTICAL);

        // 3 -> Anexando elementos filhos...
        this.addView(loadingView);
        this.addView(loadingTextView);
    }

    public void setLoadingDetailedMessage(final String msg) {
        this.loadingTextView.setText(msg);
    }

    public void setLoadingText(String text) {
        if ( text != null && text.length() <= 0 ) loadingTextView.setVisibility(GONE);
        else loadingTextView.setVisibility(VISIBLE);

        if ( text == null ) loadingTextView.setText(defaultLoadingTextessage);
        else loadingTextView.setText(text);
    }
}
