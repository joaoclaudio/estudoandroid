package com.example.exemploactiontab;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

public class TabListener<T extends Fragment> implements ActionBar.TabListener {
	private Fragment mFragment;
	private final Activity mActivity;
	private final String mTag;
	private final Class<T> mClass;

	/**
	 * Construtror chamado cada vez que uma nova tab é criada.
	 *
	 * @param activity
	 *            Activity host, usada para instanciar o fragment.
	 * @param tag
	 *            Tag identificado do fragment.
	 * @param clz
	 *            Objeto class do fragmento, usada para instanciar o fragmento.
	 */
	public TabListener(Activity activity, String tag, Class<T> clz) {
		mActivity = activity;
		mTag = tag;
		mClass = clz;
	}

	/* A seguir, métodos para o callbacks de ActionBar.TabListener */
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		
		// Verifica se o fragment já foi inicializado
		if (mFragment == null){
			// Se não, instancia e adiciona na activity
			mFragment = Fragment.instantiate(mActivity, mClass.getName());
			ft.replace(android.R.id.content, mFragment);
		} else {
			// Se já existe, só adiciona para depois exibir
			ft.attach(mFragment);
		}
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		mFragment = mActivity.getFragmentManager().findFragmentByTag(mTag);
		if (mFragment != null){
			// Remove o fragment, porque um novo será adicionado
			ft.detach(mFragment);
		}
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
}
