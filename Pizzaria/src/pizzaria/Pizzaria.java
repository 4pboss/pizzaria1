package pizzaria;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.*;

public class Pizzaria extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel fundo1;

	public String pepperoni;
	public String mussarela;
	public String supreme;
	double valor = 0;
	double valorAdicionais = 0;
	double valorTotalGlobal = 0;

	String[] sabores = new String[] { "Pepperoni", "Mussarela", "Supreme" };

	public void calcularTotal() {
		double valorTotal = valor + valorAdicionais;
		valorTotalGlobal = valorTotal;
	}

	private BufferedImage applyAlpha(BufferedImage pb, float alpha) {
		BufferedImage img = new BufferedImage(pb.getWidth(), pb.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) img.getGraphics().create();
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2.drawImage(pb, 0, 0, null);
		g2.dispose();
		return img;
	}

	public Pizzaria() {

		setFont(new Font("Freestyle Script", Font.ITALIC, 18));
		setTitle("Pizzaria do Z\u00E9");
		setForeground(Color.RED);
		setBackground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 500);

		fundo1 = new JPanel();
		fundo1.setBackground(Color.BLACK);
		fundo1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(fundo1);
		fundo1.setLayout(null);

		// label

		JLabel lbImagePizza = new JLabel("");
		lbImagePizza.setIcon(
				new ImageIcon("C:\\Users\\unip\\Desktop\\PizzariaGit\\Pizzaria\\src\\pizzaria\\topo_logoOpp.png"));
		lbImagePizza.setBounds(36, 453, 478, 315);
		fundo1.add(lbImagePizza);

		JLabel lbPedidos = new JLabel("Pedidos :");
		lbPedidos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbPedidos.setForeground(Color.WHITE);
		lbPedidos.setBounds(207, 13, 106, 16);
		fundo1.add(lbPedidos);

		JLabel lbAdicionais = new JLabel("Adicionais :");
		lbAdicionais.setForeground(Color.WHITE);
		lbAdicionais.setBounds(409, 34, 73, 16);
		fundo1.add(lbAdicionais);

		JLabel lbSabor = new JLabel("Sabor");
		lbSabor.setForeground(Color.WHITE);
		lbSabor.setBounds(84, 46, 37, 16);
		fundo1.add(lbSabor);

		JLabel lbQnt = new JLabel("Qnt");
		lbQnt.setForeground(Color.WHITE);
		lbQnt.setBounds(194, 46, 34, 16);
		fundo1.add(lbQnt);

		JLabel lbTipo = new JLabel("Tipo");
		lbTipo.setForeground(Color.WHITE);
		lbTipo.setBounds(84, 98, 37, 16);
		fundo1.add(lbTipo);

		JLabel lbTamanho = new JLabel("Tamanho");
		lbTamanho.setForeground(Color.WHITE);
		lbTamanho.setBounds(84, 154, 56, 16);
		fundo1.add(lbTamanho);

		JTextArea carrinho = new JTextArea();
		carrinho.setBounds(84, 270, 345, 121);
		fundo1.add(carrinho);

		JSpinner qntPizza = new JSpinner();
		qntPizza.setBounds(191, 63, 37, 22);
		fundo1.add(qntPizza);

		JComboBox listaSabores = new JComboBox(sabores);
		listaSabores.addActionListener(this);
		listaSabores.setBounds(84, 63, 106, 22);
		fundo1.add(listaSabores);

		JRadioButton rbInteira = new JRadioButton("Inteira");
		rbInteira.setBounds(84, 120, 70, 25);
		fundo1.add(rbInteira);

		JRadioButton rbMeia = new JRadioButton("1/2");
		rbMeia.setBounds(158, 120, 70, 25);
		fundo1.add(rbMeia);

		JRadioButton rbIndividual = new JRadioButton("Individual");
		rbIndividual.setBounds(84, 177, 89, 25);
		fundo1.add(rbIndividual);

		JRadioButton rbRegular = new JRadioButton("Regular");
		rbRegular.setBounds(177, 177, 73, 25);
		fundo1.add(rbRegular);

		JRadioButton rbFamilia = new JRadioButton("Familia");
		rbFamilia.setBounds(254, 177, 70, 25);
		fundo1.add(rbFamilia);

		JCheckBox checkBacon = new JCheckBox("Bacon");
		checkBacon.setBounds(386, 60, 113, 25);
		fundo1.add(checkBacon);

		JCheckBox checkCebola = new JCheckBox("Cebola");
		checkCebola.setBounds(386, 90, 113, 25);
		fundo1.add(checkCebola);

		JCheckBox checkChampignon = new JCheckBox("Champignon");
		checkChampignon.setBounds(386, 120, 113, 25);
		fundo1.add(checkChampignon);

		JCheckBox checkTomate = new JCheckBox("Tomate");
		checkTomate.setBounds(386, 150, 113, 25);
		fundo1.add(checkTomate);

		JCheckBox checkCatupiry = new JCheckBox("Catupiry");
		checkCatupiry.setBounds(386, 180, 113, 25);
		fundo1.add(checkCatupiry);

		JCheckBox checkPresunto = new JCheckBox("Presunto");
		checkPresunto.setBounds(386, 210, 113, 25);
		fundo1.add(checkPresunto);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(430, 270, 21, 121);
		fundo1.add(scrollBar);

		JSlider slider = new JSlider();
		slider.setBounds(84, 393, 367, 9);
		fundo1.add(slider);

		JButton adicionarCarrinho = new JButton("Adicionar ao Carrinho");
		adicionarCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {

				DecimalFormat df = new DecimalFormat("0.00");

				double valorPepperoniI = 15.00, valorMussarelaI = 12.00, valorSupremeI = 17.00;
				double valorPepperoniR = 27.00, valorMussarelaR = 21.60, valorSupremeR = 30.60;
				double valorPepperoniF = 33.00, valorMussarelaF = 26.40, valorSupremeF = 37.40;
				double valorBacon = 2.00, valorCebola = 1.50, valorChampignon = 2.50, valorTomate = 1.50,
						valorCatupiry = 3.00, valorPresunto = 2.50;

				String tipo = "";
				String tamanho = "";
				String adicionais = "";
				double valor = 0;
				double valorAdicionais = 0;

				Integer quantidade = (Integer) qntPizza.getValue();

				if (rbInteira.isSelected()) {
					tipo = "Inteira";
				} else if (rbMeia.isSelected())
					tipo = "Meio a Meio";

				if (rbIndividual.isSelected()) {
					tamanho = "Individual";
					if (listaSabores.getSelectedIndex() == 0) {
						valor = valorPepperoniI;
					} else if (listaSabores.getSelectedIndex() == 1) {
						valor = valorMussarelaI;
					} else if (listaSabores.getSelectedIndex() == 2) {
						valor = valorSupremeI;
					}
				}
				if (rbRegular.isSelected()) {
					tamanho = "Regular";
					if (listaSabores.getSelectedIndex() == 0) {
						valor = valorPepperoniR;
					} else if (listaSabores.getSelectedIndex() == 1) {
						valor = valorMussarelaR;
					} else if (listaSabores.getSelectedIndex() == 2) {
						valor = valorSupremeR;
					}
				}
				if (rbFamilia.isSelected()) {
					tamanho = "Familia";
					if (listaSabores.getSelectedIndex() == 0) {
						valor = valorPepperoniF;
					} else if (listaSabores.getSelectedIndex() == 1) {
						valor = valorMussarelaF;
					} else if (listaSabores.getSelectedIndex() == 2) {
						valor = valorSupremeF;
					}
				}
				/*
				 * if (rbIndividual.isSelected() && rbRegular.isSelected())
				 * carrinho.setText("\nVoce não pode ter 2 tamanhos diferentes de pizza"); if
				 * (rbIndividual.isSelected() && rbFamilia.isSelected())
				 * carrinho.setText("\nVoce não pode ter 2 tamanhos diferentes de pizza"); if
				 * (rbRegular.isSelected() && rbIndividual.isSelected())
				 * carrinho.setText("\nVoce não pode ter 2 tamanhos diferentes de pizza"); if
				 * (rbRegular.isSelected() && rbFamilia.isSelected())
				 * carrinho.setText("\nVoce não pode ter 2 tamanhos diferentes de pizza"); if
				 * (rbFamilia.isSelected() && rbIndividual.isSelected())
				 * carrinho.setText("\nVoce não pode ter 2 tamanhos diferentes de pizza"); if
				 * (rbFamilia.isSelected() && rbRegular.isSelected())
				 * carrinho.setText("\nVoce não pode ter 2 tamanhos diferentes de pizza");
				 */
				if (checkBacon.isSelected()) {
					adicionais = "Bacon";
					valorAdicionais = valorBacon;
				} else if (checkCebola.isSelected()) {
					adicionais = "Cebola";
					valorAdicionais = valorCebola;
				} else if (checkChampignon.isSelected()) {
					adicionais = "Champignon";
					valorAdicionais = valorChampignon;
				} else if (checkTomate.isSelected()) {
					adicionais = "Tomate";
					valorAdicionais = valorTomate;
				} else if (checkCatupiry.isSelected()) {
					adicionais = "Catupiry";
					valorAdicionais = valorCatupiry;
				} else if (checkPresunto.isSelected()) {
					adicionais = "Presunto";
					valorAdicionais = valorPresunto;
				}

				carrinho.setText("\nQuantidade: " + quantidade + "\nTipo: " + tipo + "\nSabor: "
						+ listaSabores.getSelectedItem() + "\nTamanho: " + tamanho + "\tValor: R$" + df.format(valor)
						+ "\nAdicionais: " + adicionais + "\tValor: R$" + df.format(valorAdicionais));
			}
		});
		adicionarCarrinho.setBounds(179, 232, 160, 25);
		fundo1.add(adicionarCarrinho);
		adicionarCarrinho.setOpaque(false);

		JButton confirmarPedido = new JButton("Confirmar Pedido");
		confirmarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent cf) {
				double valorTotal = valor + valorAdicionais;
				// carrinho.setText();
			}
		});
		confirmarPedido.setBounds(177, 415, 162, 25);
		fundo1.add(confirmarPedido);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}
