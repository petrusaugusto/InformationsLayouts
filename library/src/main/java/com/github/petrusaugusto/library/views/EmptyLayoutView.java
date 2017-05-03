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

public class EmptyLayoutView extends LinearLayout {
    protected String defaultEmptyTextMessage;
    protected ImageView warningIconView;
    protected TextView layoutWarnTextMessage, warningDetailsMessage;

    public EmptyLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.InitializeViewElements(context);

        // Definindo atributos via XML
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.EmptyLayoutView, 0, 0);
        try {
            this.setEmptyText(a.getString(R.styleable.EmptyLayoutView_emptyText));
            if ( !a.getBoolean(R.styleable.EmptyLayoutView_showEmptyIcon, true) ) this.warningIconView.setVisibility(GONE);
        } finally {
            a.recycle();
        }
    }

    public EmptyLayoutView(Context context) {
        super(context);
        this.InitializeViewElements(context);
    }

    private void InitializeViewElements(Context context) {
        // 0 -> Definindo o texto padrão
        this.defaultEmptyTextMessage = context.getString(R.string.informations_layouts_default_empty_text);

        // 1 -> Inicializando elementos filhos
        // Criando elementos de imagens/icones
        warningIconView = new ImageView(context);
        warningIconView.setImageResource(R.mipmap.infomations_layouts_ic_warning);
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
        warningIconView.setLayoutParams(new ViewGroup.LayoutParams(width, height));

        // Criando os elementos de texto
        layoutWarnTextMessage = new TextView(context);
        layoutWarnTextMessage.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layoutWarnTextMessage.setText(this.defaultEmptyTextMessage);
        layoutWarnTextMessage.setTextColor(context.getResources().getColor(R.color.warning_text_color));
        warningDetailsMessage = new TextView(context);
        warningDetailsMessage.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        warningDetailsMessage.setText("");

        // 2 -> Definindo os parametros padrao do elemento
        this.setGravity(Gravity.CENTER);
        this.setOrientation(VERTICAL);

        // 3 -> Anexando elementos filhos...
        this.addView(warningIconView);
        this.addView(layoutWarnTextMessage);
        this.addView(warningDetailsMessage);
    }

    public void setWarningDetailsMessage(final String dtMsg) {
        this.warningDetailsMessage.setText(dtMsg);
    }

    public void setEmptyText(String text) {
        if ( text != null && text.length() <= 0 ) layoutWarnTextMessage.setVisibility(GONE);
        else layoutWarnTextMessage.setVisibility(VISIBLE);

        if ( text == null ) layoutWarnTextMessage.setText(defaultEmptyTextMessage);
        else layoutWarnTextMessage.setText(text);
    }
}
