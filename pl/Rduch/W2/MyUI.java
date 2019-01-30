package pl.Rduch.W2;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	Layout ley1 = new VerticalLayout();
    	
    	Label l1 = new Label("hahahaha");
       
    	Button[] but = new Button[5];
    	for (int i=0; i<5; i++)
    	{
    		//int zmienna1 = i;
    		String zmstr = Integer.toString(i);
    		but[i] = new Button("Przycisk "+i);
    		ley1.addComponent(but[i]);
    		but[i].addClickListener(e -> 
    		{
    			l1.setCaption("Przyciśnięto przycisk nr "+zmstr);
    		}
    		);
    	}
    	
    	ley1.addComponent(l1);
    	
    	setContent(ley1);
    	
    	
      //setContent(l1);
    	
    	/*  final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        layout.addComponents(name, button);
        
        setContent(layout);*/
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
