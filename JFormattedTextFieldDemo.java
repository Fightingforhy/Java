import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.*;
import java.text.NumberFormat;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

class JFormattedTextFieldDemo implements PropertyChangeListener
{
    JFrame mainFrame;
    JPanel mainPanel;
    JFormattedTextField priceFormattedTextField;
    JFormattedTextField discountFormattedTextField;
    JFormattedTextField paymentFormattedTextField;
    JLabel priceLabel;
    JLabel discountLabel;
    JLabel paymentLabel;
    NumberFormat priceFormat;
    NumberFormat discountFormat;
    NumberFormat paymentFormat;
    public JFormattedTextFieldDemo() {
        mainFrame = new JFrame ( "JFormattedTextFieldDemo" );
        mainPanel = new JPanel ( new GridLayout(3,2) );
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        priceFormat = NumberFormat.getNumberInstance();
        priceFormattedTextField = new JFormattedTextField(priceFormat);
        priceFormattedTextField.setValue(72.023);
        priceFormattedTextField.addPropertyChangeListener("value",this);
        priceLabel = new JLabel ("Price");
        priceLabel.setLabelFor( priceFormattedTextField );
        mainPanel.add( priceLabel );
        mainPanel.add( priceFormattedTextField );

        discountFormat = NumberFormat.getPercentInstance();
        discountFormattedTextField = new JFormattedTextField(discountFormat);
        discountFormattedTextField.setValue(0.75);
        discountFormattedTextField.addPropertyChangeListener("value",this);
        discountLabel = new JLabel ("Discount");
        discountLabel.setLabelFor( discountFormattedTextField );
        mainPanel.add( discountLabel );
        mainPanel.add( discountFormattedTextField );

        paymentFormat = NumberFormat.getCurrencyInstance();
        paymentFormattedTextField = new JFormattedTextField(paymentFormat);
        paymentFormattedTextField.setEditable( false );
        paymentFormattedTextField.addPropertyChangeListener("value",this);
        paymentLabel = new JLabel ("Payment");
        paymentLabel.setLabelFor( paymentFormattedTextField );
        mainPanel.add( paymentLabel );
        mainPanel.add( paymentFormattedTextField );

        mainFrame.getContentPane().add( mainPanel );
        mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mainFrame.pack();
        mainPanel.setSize(300,300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible( true );
    }
    public void propertyChange( PropertyChangeEvent e ){
        double price = ((Number)priceFormattedTextField.getValue()).doubleValue();
        double discount = ((Number)discountFormattedTextField.getValue()).doubleValue();
        paymentFormattedTextField.setValue( price*discount );
    }
    public static void main(String[] args)
    {
        new JFormattedTextFieldDemo();
    }
}