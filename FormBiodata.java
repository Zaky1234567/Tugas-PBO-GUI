import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormBiodata extends JFrame implements ActionListener, MouseListener {
    
    private JLabel lblJudul, lblNim, lblNama, lblProdi, lblGender;
    private JTextField txtNim, txtNama;
    private JComboBox<String> cmbProdi;
    private JRadioButton rbLaki, rbPerempuan;
    private ButtonGroup bgGender;
    private JButton btnSubmit, btnClear;
    private JTextArea txtOutput;
    
    private JPanel panelHeader, panelForm, panelGender, panelButton;

    public FormBiodata() {
        // Pengaturan Top-Level Container (JFrame)
        setTitle("Sistem Input Biodata Mahasiswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 420);
        setLocationRelativeTo(null); 
        
        setLayout(new BorderLayout(10, 10));

        panelHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelHeader.setBackground(new Color(41, 128, 185));
        lblJudul = new JLabel("FORM BIODATA MAHASISWA");
        lblJudul.setForeground(Color.WHITE);
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 16));
        panelHeader.add(lblJudul);

        panelForm = new JPanel(new GridLayout(4, 2, 8, 8));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 15, 5, 15));

        lblNim = new JLabel("NIM Mahasiswa:");
        txtNim = new JTextField();
        
        lblNama = new JLabel("Nama Lengkap:");
        txtNama = new JTextField();
        
        lblProdi = new JLabel("Program Studi:");
        String[] daftarProdi = {"Teknik Informatika", "Sistem Informasi", "Teknik Elektro", "Teknik Sipil"};
        cmbProdi = new JComboBox<>(daftarProdi);

        lblGender = new JLabel("Jenis Kelamin:");
        panelGender = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        rbLaki = new JRadioButton("Laki-laki", true);
        rbPerempuan = new JRadioButton("Perempuan");
        bgGender = new ButtonGroup();
        bgGender.add(rbLaki);
        bgGender.add(rbPerempuan);
        panelGender.add(rbLaki);
        panelGender.add(rbPerempuan);
        
        panelForm.add(lblNim);
        panelForm.add(txtNim);
        panelForm.add(lblNama);
        panelForm.add(txtNama);
        panelForm.add(lblProdi);
        panelForm.add(cmbProdi);
        panelForm.add(lblGender);
        panelForm.add(panelGender);

        JPanel panelTengah = new JPanel(new BorderLayout(5, 10));
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtOutput.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        
        JScrollPane scrollOutput = new JScrollPane(txtOutput);
        scrollOutput.setBorder(BorderFactory.createTitledBorder("Hasil Output Data"));

        panelTengah.add(panelForm, BorderLayout.NORTH);
        panelTengah.add(scrollOutput, BorderLayout.CENTER);

        panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnSubmit = new JButton("Simpan Data");
        btnClear = new JButton("Reset Form");
        
        panelButton.add(btnSubmit);
        panelButton.add(btnClear);
        
        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);
        btnSubmit.addMouseListener(this);
        btnClear.addMouseListener(this);

        txtNim.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }
        });

        add(panelHeader, BorderLayout.NORTH); 
        add(panelTengah, BorderLayout.CENTER); 
        add(panelButton, BorderLayout.SOUTH); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String nim = txtNim.getText().trim();
            String nama = txtNama.getText().trim();
            
            if (nim.isEmpty() || nama.isEmpty()) {
                JOptionPane.showMessageDialog(this, "NIM dan Nama tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String prodi = cmbProdi.getSelectedItem().toString();
            String gender = rbLaki.isSelected() ? "Laki-laki" : "Perempuan";
            
            txtOutput.setText("=== DATA MAHASISWA TERSIMPAN ===\n");
            txtOutput.append("NIM           : " + nim + "\n");
            txtOutput.append("Nama          : " + nama + "\n");
            txtOutput.append("Program Studi : " + prodi + "\n");
            txtOutput.append("Jenis Kelamin : " + gender + "\n");
        } else if (e.getSource() == btnClear) {
            txtNim.setText("");
            txtNama.setText("");
            cmbProdi.setSelectedIndex(0);
            rbLaki.setSelected(true);
            txtOutput.setText("");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton btn = (JButton) e.getSource();
            btn.setBackground(new Color(174, 214, 241));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton btn = (JButton) e.getSource();
            btn.setBackground(UIManager.getColor("Button.background"));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormBiodata().setVisible(true);
        });
    }
}