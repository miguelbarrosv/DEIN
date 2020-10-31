package LP;

import javax.swing.DefaultComboBoxModel;

public class ModeloAlta extends DefaultComboBoxModel<clsDeporte> 
 {
	 private ArrayList<clsDeporte>lista;
		
		public ModeloAlta(ArrayList<clsDeporte>_lista)
		{
			this.lista = _lista;
		}
		
		public void addElement(clsDeporte elemento)
		{
			lista.add(elemento);
			this.fireContentsChanged(this, lista.size(), lista.size());
		}
		
		public clsDeporte getElementAt(int index)
		{
		    return lista.get(index);
		}
		
		public int getSize()
		{
		    return lista.size();
		}
 }
