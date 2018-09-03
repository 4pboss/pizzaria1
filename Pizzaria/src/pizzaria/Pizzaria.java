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

	String[] sabores = new String[] { "Pepperoni", "Mussarela", "Supreme" };

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
		setBounds(100, 100, 541, 470);

		fundo1 = new JPanel();
		fundo1.setBackground(Color.BLACK);
		fundo1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(fundo1);
		fundo1.setLayout(null);

		// label

		JLabel lbImagePizza = new JLabel("");
		lbImagePizza.setIcon(
				new ImageIcon("C:\\Users\\unip\\Desktop\\PizzariaGit\\Pizzaria\\src\\pizzaria\\topo_logoOpp.png"));
		lbImagePizza.setBounds(12, 415, 499, 248);
		fundo1.add(lbImagePizza);

		JLabel lbPedidos = new JLabel("Pedidos :");
		lbPedidos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbPedidos.setForeground(Color.WHITE);
		lbPedidos.setBounds(201, 31, 106, 16);
		fundo1.add(lbPedidos);

		JTextArea carrinho = new JTextArea();
		carrinho.setBounds(84, 249, 345, 121);
		fundo1.add(carrinho);

		JSpinner qntPizza = new JSpinner();
		qntPizza.setBounds(191, 81, 37, 22);
		fundo1.add(qntPizza);

		JComboBox listaSabores = new JComboBox(sabores);
		listaSabores.addActionListener(this);
		listaSabores.setBounds(84, 81, 106, 22);
		fundo1.add(listaSabores);

		JRadioButton rbInteira = new JRadioButton("Inteira");
		rbInteira.setBounds(84, 123, 70, 25);
		fundo1.add(rbInteira);

		JRadioButton rbMeia = new JRadioButton("1/2");
		rbMeia.setBounds(158, 123, 70, 25);
		fundo1.add(rbMeia);

		JRadioButton rbIndividual = new JRadioButton("Individual");
		rbIndividual.setBounds(84, 153, 89, 25);
		fundo1.add(rbIndividual);

		JRadioButton rbRegular = new JRadioButton("Regular");
		rbRegular.setBounds(177, 153, 73, 25);
		fundo1.add(rbRegular);

		JRadioButton rbFamilia = new JRadioButton("Familia");
		rbFamilia.setBounds(254, 153, 70, 25);
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
		scrollBar.setBounds(430, 249, 21, 121);
		fundo1.add(scrollBar);

		JSlider slider = new JSlider();
		slider.setBounds(84, 369, 367, 9);
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

				String tamanho = "";
				double valor = 0;

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
				if (checkBacon.isSelected()) {
					
				}
				carrinho.setText("\nSabor: " + listaSabores.getSelectedItem() + "\nTamanho: " + tamanho + "\nValor: R$"
						+ df.format(valor));
			}
		});
		adicionarCarrinho.setBounds(179, 211, 160, 25);
		fundo1.add(adicionarCarrinho);
		adicionarCarrinho.setOpaque(false);

		JButton confirmarPedido = new JButton("Confirmar Pedido");
		confirmarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent cf) {

			}
		});
		confirmarPedido.setBounds(177, 383, 162, 25);
		fundo1.add(confirmarPedido);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
