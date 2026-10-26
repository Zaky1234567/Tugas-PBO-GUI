import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormBiodata extends JFrame implements ActionListener, MouseListener {
    
    private JLabel lblNim, lblNama;
    private JTextField txtNim, txtNama;
    private JButton btnSubmit, btnClear;
    private JTextArea txtOutput;
    
    private JPanel panelForm, panelButton;

    public FormBiodata() {
        setTitle("Form Biodata Mahasiswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); 
        
        setLayout(new BorderLayout(10, 10));

        panelForm = new JPanel(new GridLayout(2, 2, 5, 5));
        lblNim = new JLabel("NIM Mahasiswa:");
        txtNim = new JTextField();
        lblNama = new JLabel("Nama Mahasiswa:");
        txtNama = new JTextField();
        
        panelForm.add(lblNim);
        panelForm.add(txtNim);
        panelForm.add(lblNama);
        panelForm.add(txtNama);

        panelButton = new JPanel(new FlowLayout());
        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Clear");
        
        panelButton.add(btnSubmit);
        panelButton.add(btnClear);

        txtOutput = new JTextArea();
        txtOutput.setEditable(false); 
        
        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);
        
        btnSubmit.addMouseListener(this);
        btnClear.addMouseListener(this);

        add(panelForm, BorderLayout.NORTH); 
        add(new JScrollPane(txtOutput), BorderLayout.CENTER); 
        add(panelButton, BorderLayout.SOUTH); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String nim = txtNim.getText();
            String nama = txtNama.getText();
            
            txtOutput.setText("Data Berhasil Disimpan!\n");
            txtOutput.append("NIM  : " + nim + "\n");
            txtOutput.append("Nama : " + nama + "\n");
        } else if (e.getSource() == btnClear) {
            txtNim.setText("");
            txtNama.setText("");
            txtOutput.setText("");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton btn = (JButton) e.getSource();
            btn.setBackground(Color.CYAN);
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
        FormBiodata app = new FormBiodata();
        app.setVisible(true);
    }
}