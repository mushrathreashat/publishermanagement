import javax.swing.*;
import java.awt.event.*;

public class PublisherGUI extends JFrame implements ActionListener {
    JTextField txtId, txtName, txtCountry, txtContact;
    JButton btnRegister, btnShowAll;
    JTextArea txtShowAll;

    public PublisherGUI() {
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lbTitle = new JLabel("Publisher Registration");
        lbTitle.setBounds(20, 0, 200, 20);
        add(lbTitle);

        JLabel lbId = new JLabel("Publisher ID");
        lbId.setBounds(20, 30, 100, 20);
        add(lbId);

        txtId = new JTextField();
        txtId.setBounds(120, 30, 100, 20);
        add(txtId);

        JLabel lbName = new JLabel("Name");
        lbName.setBounds(20, 60, 100, 20);
        add(lbName);

        txtName = new JTextField();
        txtName.setBounds(120, 60, 100, 20);
        add(txtName);

        JLabel lbCountry = new JLabel("Country");
        lbCountry.setBounds(20, 90, 100, 20);
        add(lbCountry);

        txtCountry = new JTextField();
        txtCountry.setBounds(120, 90, 100, 20);
        add(txtCountry);

        JLabel lbContact = new JLabel("Contact");
        lbContact.setBounds(20, 120, 100, 20);
        add(lbContact);

        txtContact = new JTextField();
        txtContact.setBounds(120, 120, 100, 20);
        add(txtContact);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(120, 160, 100, 20);
        add(btnRegister);
        btnRegister.addActionListener(this);

        btnShowAll = new JButton("Show All");
        btnShowAll.setBounds(120, 190, 100, 20);
        add(btnShowAll);
        btnShowAll.addActionListener(this);

        txtShowAll = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtShowAll);
        scroll.setBounds(250, 30, 300, 400);
        add(scroll);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            registerClicked();
        } else if (e.getSource() == btnShowAll) {
            showAllClicked();
        }
    }

    private void registerClicked() {
        String id = txtId.getText();
        String name = txtName.getText();
        String country = txtCountry.getText();
        String contact = txtContact.getText();

        Publisher pub = new Publisher(id, name, country, contact);
        PublisherManager manager = new PublisherManager();
        manager.writePublisher(pub);

        JOptionPane.showMessageDialog(null, "Publisher Registered!");
        refreshFields();
        showAllClicked();
    }

    private void showAllClicked() {
        PublisherManager manager = new PublisherManager();
        Publisher[] publishers = manager.getAllPublishers();
        String output = "";
        for (Publisher pub : publishers) {
            output += pub.showInfoGUI();
        }
        txtShowAll.setText(output);
    }

    private void refreshFields() {
        txtId.setText("");
        txtName.setText("");
        txtCountry.setText("");
        txtContact.setText("");
    }
}