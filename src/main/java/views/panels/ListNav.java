/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import views.panels.*;

/**
 *
 * @author hp
 * @param <E>
 */
public class ListNav<E extends Object> extends JList<E> {
 
    private final DefaultListModel model;
    private int selectedIndex = -1;
    private int overIndex = -1;
    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event){
        this.event = event;
    }
    
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
                            if(event != null){
                                event.selected(index);
                            }
                        }
                    }else{
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
            public void mouseExited(MouseEvent me){
                 overIndex = -1;
                 repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent me) {
                int index = locationToIndex(me.getPoint());
                if(index!=overIndex){
                    Object o = model.getElementAt(index);
                    if(o instanceof Nav_model){
                        Nav_model menu = (Nav_model)o;
                        if(menu.getType() == Nav_model.MenuType.MENU){
                            overIndex = index;
                        }else{
                            overIndex = -1;
                        }
                        repaint();
                    }
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
                item.setOver(overIndex==index);
                return item;
            }  
        };
    }
    public void addItem(Nav_model data){
        model.addElement(data);
    }
}
