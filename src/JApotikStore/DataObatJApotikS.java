package JApotikStore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class DataObatJApotikS {
//Instance 
	private int ArrayKe;
	private JComboBox<String> cbSatuan;
	private JComboBox<String> cbKategori;
	private JComboBox<String> cbJenisObat;
	private JSpinner spinnerStok;
	private JTextArea tAKeterangan;
	private JFrame frame;
	private JTextField tfCari;
	private JTextField tfKodeObat;
	private JTextField tfNamaObat;
	private JTable table;
	private DefaultTableModel tabelModel;
	private JButton buttonHapus;
//Arraylist untuk menyimpan data-data obat
	ArrayList<Obat> obat = new ArrayList<Obat>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataObatJApotikS window = new DataObatJApotikS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataObatJApotikS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("removal")
	private void initialize() {
		ArrayKe = 0;

		tabelModel = new DefaultTableModel();
		tabelModel.addColumn("Kode Obat");
		tabelModel.addColumn("Nama Obat");
		tabelModel.addColumn("Stock");

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(221, 160, 221));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1283, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 1279, 67);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel ApotekJJ = new JLabel("APOTEK JJ\r\n");
		ApotekJJ.setFont(new Font("Ink Free", Font.PLAIN, 20));
		ApotekJJ.setBounds(550, 10, 114, 22);
		panel.add(ApotekJJ);

		JLabel Alamat = new JLabel("Komplek Jatayu 1 No. 6 Lanud Supadio");
		Alamat.setFont(new Font("Ink Free", Font.PLAIN, 10));
		Alamat.setBounds(529, 23, 268, 22);
		panel.add(Alamat);

		JLabel NomorHp = new JLabel("(0561) 359604");
		NomorHp.setFont(new Font("Ink Free", Font.PLAIN, 10));
		NomorHp.setBounds(568, 35, 124, 22);
		panel.add(NomorHp);

		JLabel LogoAtas = new JLabel("");
		LogoAtas.setIcon(new ImageIcon(DataObatJApotikS.class.getResource("/Images/LOGO.png")));
		LogoAtas.setBounds(0, -11, 68, 88);
		panel.add(LogoAtas);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 182, 193));
		panel_1.setBounds(658, 92, 564, 400);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 52, 544, 338);
		panel_1.add(scrollPane_1);

		table = new JTable();
		table.setModel(tabelModel);
		scrollPane_1.setViewportView(table);

		JLabel tagCari = new JLabel("Cari");
		tagCari.setBounds(10, 20, 65, 17);
		panel_1.add(tagCari);
		tagCari.setFont(new Font("Tahoma", Font.PLAIN, 18));

		tfCari = new JTextField();
		tfCari.setBounds(70, 23, 269, 17);
		panel_1.add(tfCari);
		tfCari.setColumns(10);

		JButton btnCariId = new JButton("Cari Id");
		btnCariId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelModel.setRowCount(0);
				for (int i = 0; i < obat.size(); i++) {
					Obat tempObat = (Obat) obat.get(i);
					if (tempObat.getKodeObat().matches("(.*)" + tfCari.getText() + "(.*)")) {
						String kdObat = obat.get(i).KodeObat;
						String nmObat = obat.get(i).NamaObat;
						String stock = obat.get(i).Stok;
						Object[] dataObat = { kdObat, nmObat, stock };
						tabelModel.addRow(dataObat);
					}
				}
				refreshData();
			}
		});
		btnCariId.setBounds(362, 21, 85, 21);
		panel_1.add(btnCariId);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 182, 193));
		panel_2.setForeground(Color.WHITE);
		panel_2.setBounds(60, 92, 490, 400);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel tagKodeObat = new JLabel("Kode Obat");
		tagKodeObat.setBounds(0, 10, 70, 22);
		panel_2.add(tagKodeObat);

		JLabel tagSatuan = new JLabel("Satuan");
		tagSatuan.setBounds(0, 80, 88, 28);
		panel_2.add(tagSatuan);

		JLabel tagKategori = new JLabel("Kategori");
		tagKategori.setBounds(0, 118, 88, 28);
		panel_2.add(tagKategori);

		JLabel tagJenisObat = new JLabel("Jenis Obat");
		tagJenisObat.setBounds(0, 153, 88, 28);
		panel_2.add(tagJenisObat);

		JLabel tagStok = new JLabel("Stok");
		tagStok.setBounds(0, 191, 88, 28);
		panel_2.add(tagStok);

		JLabel tagNamaObat = new JLabel("Nama Obat");
		tagNamaObat.setBounds(0, 42, 88, 28);
		panel_2.add(tagNamaObat);

		JLabel tagKeterangan = new JLabel("Keterangan");
		tagKeterangan.setBounds(0, 237, 70, 14);
		panel_2.add(tagKeterangan);

		tfKodeObat = new JTextField();
		tfKodeObat.setBounds(142, 12, 138, 20);
		panel_2.add(tfKodeObat);
		tfKodeObat.setColumns(10);

		tfNamaObat = new JTextField();
		tfNamaObat.setBounds(142, 48, 138, 20);
		panel_2.add(tfNamaObat);
		tfNamaObat.setColumns(10);

		cbSatuan = new JComboBox<String>();
		cbSatuan.setModel(new DefaultComboBoxModel<String>(new String[] { "Botol", "Kotak", "Strip" }));
		cbSatuan.setBounds(142, 82, 138, 24);
		panel_2.add(cbSatuan);

		JScrollPane scrollPaneKeterangan = new JScrollPane();
		scrollPaneKeterangan.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneKeterangan.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneKeterangan.setBounds(142, 247, 320, 143);
		panel_2.add(scrollPaneKeterangan);

		tAKeterangan = new JTextArea();
		tAKeterangan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char a = e.getKeyChar();
				String b = String.valueOf(a);
				if (!(b.matches("(.*)[a-zA-Z ,.](.*)")) && (b != "\b")) {
					e.consume();
				}
			}
		});
		
		tAKeterangan.setLineWrap(true);
		scrollPaneKeterangan.setColumnHeaderView(tAKeterangan);

		cbKategori = new JComboBox<String>();
		cbKategori.setModel(new DefaultComboBoxModel<String>(new String[] { "O. Bebas", "O. Bebas Terbatas", "O. Keras", "O. Golongan Narkotik", "O. Fitofarmaka", "O. Herbal Terstandar", "O. Herbal" }));
		cbKategori.setBounds(142, 120, 138, 24);
		panel_2.add(cbKategori);

		cbJenisObat = new JComboBox<String>();
		cbJenisObat.setModel(new DefaultComboBoxModel<String>(new String[] { "Cair", "Tablet", "Kapsul", "Oles", "Tetes", "Suntik" }));
		cbJenisObat.setBounds(142, 155, 138, 24);
		panel_2.add(cbJenisObat);

		spinnerStok = new JSpinner();
		spinnerStok.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerStok.setBounds(142, 196, 138, 20);
		panel_2.add(spinnerStok);

		JButton buttonTambah = new JButton("Tambah");
		buttonTambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String kdObat = tfKodeObat.getText();
					String nmObat = tfNamaObat.getText();
					String satuan = cbSatuan.getSelectedItem().toString();
					String kategori = cbKategori.getSelectedItem().toString();
					String jobat = cbJenisObat.getSelectedItem().toString();
					String stok = spinnerStok.getValue().toString();
					String keterangan = tAKeterangan.getText();

					Boolean check = false;
					if (!(kdObat.equals("")) && !(nmObat.equals("")) && !(keterangan.equals(""))) {
						for (int i = 0; i < obat.size(); i++) {
							if (obat.get(i).KodeObat.equals(tfKodeObat.getText())	) {
								check = true;
							}
						}
						if (check == true) {
							JOptionPane.showMessageDialog(null, "Kode Obat Sudah terdaftar");
						} else {
							obat.add(new Obat(kdObat, nmObat, satuan, kategori, jobat, stok, keterangan));
							refreshData();
						}
						refreshTabel();
					} else {
						JOptionPane.showMessageDialog(null, "Silahkan Isi Data Terlebih Dahulu");
					}

				} catch (Exception o) {
					JOptionPane.showMessageDialog(null, "Harap Masukan Data Dengan Benar");
				}

			}
		});
		
		buttonTambah.setBounds(70, 512, 85, 21);
		frame.getContentPane().add(buttonTambah);

		JButton buttonUbah = new JButton("Ubah");
		buttonUbah.setEnabled(false);
		buttonUbah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kdObat = tfKodeObat.getText();
				String nmObat = tfNamaObat.getText();
				String satuan = cbSatuan.getSelectedItem().toString();
				String kategori = cbKategori.getSelectedItem().toString();
				String jobat = cbJenisObat.getSelectedItem().toString();
				String stok = spinnerStok.getValue().toString();
				String keterangan = tAKeterangan.getText();

				int reply = JOptionPane.showConfirmDialog(null, "Apakah Yakin Ingin Mengubah Data?", "", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					obat.get(ArrayKe).setKodeObat(kdObat);
					obat.get(ArrayKe).setNamaObat(nmObat);
					obat.get(ArrayKe).setSatuan(satuan);
					obat.get(ArrayKe).setKategori(kategori);
					obat.get(ArrayKe).setJenisObat(jobat);
					obat.get(ArrayKe).setStok(stok);
					obat.get(ArrayKe).setKeterangan(keterangan);
					buttonUbah.setEnabled(false);
					buttonTambah.setEnabled(true);
					buttonHapus.setEnabled(false);
					refreshTabel();
					refreshData();
					JOptionPane.showMessageDialog(null, "Data DiUbah");
				} else {
					JOptionPane.showMessageDialog(null, "Dibatalkan");
				}
			}
		});
		
		buttonUbah.setBounds(355, 513, 85, 21);
		frame.getContentPane().add(buttonUbah);

		buttonHapus = new JButton("Hapus");
		buttonHapus.setEnabled(false);
		buttonHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int reply = JOptionPane.showConfirmDialog(null, "Apakah Yakin Ingin Menghapus Data?", "",JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					obat.remove(ArrayKe);
					buttonHapus.setEnabled(false);
					buttonUbah.setEnabled(false);
					buttonTambah.setEnabled(true);
					JOptionPane.showMessageDialog(null, "Data Dihapus");
				} else {
					JOptionPane.showMessageDialog(null, "Dibatalkan");
				}
				refreshTabel();
				refreshData();
			}
		});
		buttonHapus.setBounds(449, 513, 85, 21);
		frame.getContentPane().add(buttonHapus);

		JLabel InformasiObat = new JLabel("Informasi Obat");
		InformasiObat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		InformasiObat.setBounds(60, 64, 148, 28);
		frame.getContentPane().add(InformasiObat);

		JButton btnPilih = new JButton("Pilih");
		btnPilih.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					String Terpilih = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);

					for (int i = 0; i < obat.size(); i++) {
						Obat tempObat = (Obat) obat.get(i);
						if (tempObat.getKodeObat().equals(Terpilih)) {
							tfKodeObat.setText(tempObat.KodeObat);
							tfNamaObat.setText(tempObat.NamaObat);
							cbSatuan.setSelectedItem(tempObat.Satuan);
							cbKategori.setSelectedItem(tempObat.Kategori);
							cbJenisObat.setSelectedItem(tempObat.JenisObat);
							spinnerStok.setValue(Integer.valueOf(tempObat.Stok));
							tAKeterangan.setText(tempObat.Keterangan);
							ArrayKe = i;
							buttonUbah.setEnabled(true);
							buttonHapus.setEnabled(true);
							buttonTambah.setEnabled(false);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Pilih Baris Terlebih Dahulu");
				}
			}
		});
		
		btnPilih.setBounds(960, 502, 85, 21);
		frame.getContentPane().add(btnPilih);

		JButton btnBatal = new JButton("Batal");
		btnBatal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshData();
				buttonHapus.setEnabled(false);
				buttonUbah.setEnabled(false);
				buttonTambah.setEnabled(true);
				refreshTabel();
			}
		});
		
		btnBatal.setBounds(165, 513, 85, 21);
		frame.getContentPane().add(btnBatal);

		JButton btnRefersh = new JButton("Refresh");
		btnRefersh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTabel();
				refreshData();
			}
		});
		
		btnRefersh.setBounds(845, 502, 85, 21);
		frame.getContentPane().add(btnRefersh);

		JLabel LogoBawah = new JLabel("");
		LogoBawah.setIcon(new ImageIcon(DataObatJApotikS.class.getResource("/Images/LOGO.png")));
		LogoBawah.setBounds(1212, 512, 67, 54);
		frame.getContentPane().add(LogoBawah);

	}
//method refresh table
	public void refreshTabel() {
		tabelModel.setRowCount(0);

		for (int i = 0; i < obat.size(); i++) {
			String kdObat = obat.get(i).KodeObat;
			String nmObat = obat.get(i).NamaObat;
			String stock = obat.get(i).Stok;

			Object[] dataObat = { kdObat, nmObat, stock };
			tabelModel.addRow(dataObat);
		}
	}
//method refresh data
	public void refreshData() {
		tfKodeObat.setText("");
		tfNamaObat.setText("");
		cbSatuan.setSelectedItem("Botol");
		cbKategori.setSelectedItem("O. Bebas");
		cbJenisObat.setSelectedItem("Obat Cair");
		spinnerStok.setValue(Integer.valueOf("1"));
		tAKeterangan.setText("");
		tfCari.setText("");
	}
}
