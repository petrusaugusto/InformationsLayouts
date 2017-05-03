package com.github.petrusaugusto.library.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.petrusaugusto.library.R;


/**
 * Created by Petrus A. (R@G3), ESPE... On 04/03/2017.
 */

public class ErrorLayoutView extends LinearLayout {
    protected String defaultErrorTextMessage;
    protected ImageView errorIconView;
    protected TextView layoutErrTextMessage, errorDetailsMessage;

    public ErrorLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.InitializeViewElements(context);

        // Definindo atributos via XML
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ErrorLayoutView, 0, 0);
        try {
            this.setErrorText(a.getString(R.styleable.ErrorLayoutView_errorText));
            this.setErrorDetailsMessage(a.getString(R.styleable.ErrorLayoutView_detailedErroText));
            if ( !a.getBoolean(R.styleable.ErrorLayoutView_showErrorIcon, true) ) this.errorIconView.setVisibility(GONE);
        } finally {
            a.recycle();
        }
    }

    public ErrorLayoutView(Context context) {
        super(context);
        this.InitializeViewElements(context);
    }

    private void InitializeViewElements(Context context) {
        // 0 -> Definindo o texto padrão
        this.defaultErrorTextMessage = context.getString(R.string.informations_layouts_default_error_text);

        // 1 -> Inicializando elementos filhos
        // Criando elementos de imagens/icones
        errorIconView = new ImageView(context);
        errorIconView.setImageResource(R.mipmap.infomations_layouts_ic_error);
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
        errorIconView.setLayoutParams(new ViewGroup.LayoutParams(width, height));

        // Criando os elementos de texto
        layoutErrTextMessage = new TextView(context);
        layoutErrTextMessage.setText(defaultErrorTextMessage);
        layoutErrTextMessage.setTextColor(context.getResources().getColor(R.color.error_text_color));
        layoutErrTextMessage.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        errorDetailsMessage = new TextView(context);
        errorDetailsMessage.setText(null);
        errorDetailsMessage.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        // 2 -> Definindo os parametros padrao do elemento
        this.setGravity(Gravity.CENTER);
        this.setOrientation(VERTICAL);

        // 3 - Anexando elementos filhos...
        this.addView(errorIconView);
        this.addView(layoutErrTextMessage);
        this.addView(errorDetailsMessage);
    }

    public void setErrorDetailsMessage(final String errorDtMsg) {
        if ( errorDtMsg != null && errorDtMsg.length() <= 0 ) errorDetailsMessage.setVisibility(GONE);
        else errorDetailsMessage.setVisibility(VISIBLE);

        if ( errorDtMsg == null ) this.errorDetailsMessage.setText("");
        else this.errorDetailsMessage.setText(errorDtMsg);
    }

    public void setErrorText(String text) {
        if ( text != null && text.length() <= 0 ) layoutErrTextMessage.setVisibility(GONE);
        else layoutErrTextMessage.setVisibility(VISIBLE);

        if ( text == null ) layoutErrTextMessage.setText(defaultErrorTextMessage);
        else layoutErrTextMessage.setText(text);
    }
}
