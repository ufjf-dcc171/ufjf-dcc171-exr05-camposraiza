package aula05ex05;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class JanelaCheckBox2 extends JFrame {

private JTextField texto = new JTextField(25);
private JTextField texto2 = new JTextField(25);
    
    private final JCheckBox tributo = new JCheckBox("Tributado");
    private final JCheckBox icms = new JCheckBox("ICMS");
    private final JLabel valor = new JLabel("Valor do produto");
     private final JLabel valor2 = new JLabel("Cotação do dólar");
     private final JLabel valor3 = new JLabel("Valor final");
     private final JButton calcular = new JButton ("Calcular preço final");
     
     private float precoInicial;
     private float cotacao;

    public JanelaCheckBox2() throws HeadlessException {
    super ("Check Box");
        setLayout(new FlowLayout(FlowLayout.LEFT));
       // texto.setText("Digite o valor do produto em dólar");
        valor.setHorizontalTextPosition(SwingConstants.LEFT);
        valor.setVerticalTextPosition(SwingConstants.TOP);
        
       // texto2.setText("Digite o valor da cotação do dólar");
        valor2.setHorizontalTextPosition(SwingConstants.LEFT);
        valor2.setVerticalTextPosition(SwingConstants.VERTICAL);
             
         EscreverMensagem escreverMensagem = new EscreverMensagem();
        texto.addActionListener(escreverMensagem);
        
        add(valor);
        add(texto);
        add(valor2);
        add(texto2);
        add(tributo);
        add(icms);
        add(valor3);
        add(calcular);
        
    Calcula calcula = new Calcula();
    Clicado clicado = new Clicado();
    
    tributo.addItemListener(calcula); 
    icms.addItemListener(calcula);
    calcular.addActionListener(clicado);
    
    }

    private  class Clicado implements ActionListener {

        public Clicado() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            float valorFinal = precoInicial*cotacao;
            
            if(tributo.isSelected() && icms.isSelected()){
                
            valorFinal = (float) (valorFinal + (valorFinal*0.6));            
            valorFinal = (float) (valorFinal + valorFinal*0.18);
            
            }else if (icms.isSelected()){
            valorFinal = (float) (valorFinal + (valorFinal*0.6));
            
            }else if (tributo.isSelected()){
            valorFinal = (float) (valorFinal + (valorFinal*0.18));
            }
            valor3.setText(valor3.getText() + valorFinal);
                          
        }
    }

    private class EscreverMensagem implements ActionListener {

        public EscreverMensagem() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            precoInicial = Float.parseFloat (texto.getText());
            cotacao = Float.parseFloat (texto2.getText());
                        
        }
    }

    private class Calcula implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            
            float valorFinal = precoInicial*cotacao;
            
            if(tributo.isSelected() && icms.isSelected()){
                
            valorFinal = (float) (valorFinal + (valorFinal*0.6));            
            valorFinal = (float) (valorFinal + valorFinal*0.18);
            
            }else if (icms.isSelected()){
            valorFinal = (float) (valorFinal + (valorFinal*0.6));
            
            }else if (tributo.isSelected()){
            valorFinal = (float) (valorFinal + (valorFinal*0.18));
            }
            
            }
        }

        
    }

    

