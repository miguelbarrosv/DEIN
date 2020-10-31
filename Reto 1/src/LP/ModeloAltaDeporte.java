package LP;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import LN.clsDeporte;

public class ModeloAltaDeporte extends DefaultComboBoxModel <clsDeporte>
{

	private ArrayList<clsDeporte> listaDeportes;
	
	public ModeloAltaDeporte(ArrayList<clsDeporte> arrayList)
	{
		this.listaDeportes = arrayList;
		
	}
	
	public void addElement(clsDeporte elemento)
	{
		listaDeportes.add(elemento);
		this.fireContentsChanged(this, listaDeportes.size(), listaDeportes.size());
	}
	
	public clsDeporte getElementAt(int index)
	{
	    return listaDeportes.get(index);
	}
	
	public int getSize()
	{
	    return listaDeportes.size();
	}
}
