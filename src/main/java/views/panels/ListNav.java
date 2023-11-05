/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import views.panels.NavItems;
import views.panels.Nav_model;

/**
 *
 * @author hp
 * @param <E>
 */
public class ListNav<E extends Object> extends JList<E> {
 
    private final DefaultListModel model;
    private int selectedIndex;
    public ListNav(){
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me){
                if(SwingUtilities.isLeftMouseButton(me)){
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    if(o instanceof Nav_model){
                        Nav_model  nav = (Nav_model)o;
                        if(nav.getType() == Nav_model.MenuType.MENU){
                            selectedIndex = index;
                        }
                    }else{
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
        });
    }
    
    @Override
    public ListCellRenderer <? super E> getCellRenderer(){
        
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus){
                Nav_model data;
                if(o instanceof Nav_model){
                    data = (Nav_model)o;
                }else{
                    data = new Nav_model("", o+"", Nav_model.MenuType.EMPTY);
                }
                NavItems item = new NavItems(data);
                item.setSelected(selectedIndex==index);
                return item;
            }  
        };
    }
    public void addItem(Nav_model data){
        model.addElement(data);
    }
}
