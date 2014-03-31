package fr.istic.gwt.devinette.client;

import fr.istic.gwt.devinette.shared.FieldVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Devinette implements EntryPoint {
	  private int val = 0;
	  private int cpt;
	  private int valRandom ;
	  private VerticalPanel mainPanel = new VerticalPanel();
	  private HorizontalPanel visuPanel = new HorizontalPanel();
	  private HorizontalPanel buttonPanel = new HorizontalPanel();
	  private Button DemarrerButton = new Button("Demarrer");
	  private TextBox visuDevinetteTextBox = new TextBox();
	  private Label label = new Label("choisissez un nombre entre 1 et 100");
	  private Label LabelErreur = new Label();
	  
	public void onModuleLoad() {
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		visuPanel.add(label);
		visuPanel.add(visuDevinetteTextBox);
		visuPanel.add(LabelErreur);
		buttonPanel.setSpacing(20);
		buttonPanel.add(DemarrerButton);
		mainPanel.add(visuPanel);
		mainPanel.add(buttonPanel);
		
		RootPanel.get("mainDevinette").add(mainPanel);
		label.setVisible(false);
		visuDevinetteTextBox.setVisible(false);
  		LabelErreur.setVisible(false);

		
		 DemarrerButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  visuDevinetteTextBox.setText("");
		    	  LabelErreur.setVisible(false);
		    	  cpt = 0;
		    	  valRandom = 1 + (int)(Math.random() * ((99) + 1));
		  		label.setVisible(true);
				visuDevinetteTextBox.setVisible(true);
				DemarrerButton.setEnabled(false);

		      }
		    });

		 visuDevinetteTextBox.addKeyDownHandler(new KeyDownHandler() {
				@Override
				public void onKeyDown(KeyDownEvent event) {
					  if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
						  String newVal = visuDevinetteTextBox.getText();
				          val=Integer.parseInt(newVal);
				          cpt++;
				         random();
				        }
					
				}
			    
			});
		  
	}
	private void random() {
		if(val>100 || val<1){
	  		LabelErreur.setVisible(true);
	  		LabelErreur.setText("Vous devez choisir un nombre entre 1 et 100");
		}else{
			
		if(val>valRandom){
	  		LabelErreur.setVisible(true);
	  		LabelErreur.setText("trop grand");
		}
		if(val<valRandom){
	  		LabelErreur.setVisible(true);
	  		LabelErreur.setText("trop petit");
		}
		if(val==valRandom){
	  		LabelErreur.setVisible(true);
	  		LabelErreur.setText("vous avez gagné en "+ cpt +" coups");
	  		DemarrerButton.setEnabled(true);
	  	
		}
		}
	}
}
