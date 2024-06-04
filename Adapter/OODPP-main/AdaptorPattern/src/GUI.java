import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements UI{

    private final NameStoreAdapter nameStoreAdapter;

    public GUI(NameStoreAdapter nameStoreAdapter) {
        this.nameStoreAdapter = nameStoreAdapter;
    }


    @Override
    public void show() {
        JFrame frame = new JFrame("Name registry");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel lblOperation = new JLabel("Operation : ");
        JComboBox jcbOperation = new JComboBox();
        jcbOperation.addItem("Store");
        jcbOperation.addItem("Read");

        JLabel lblID = new JLabel("ID : ");
        JTextField txtID = new JTextField(5);

        JLabel lblName = new JLabel("Name : ");
        JTextField txtName = new JTextField(15);

        JButton btnCommit = new JButton("Commit");
        btnCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("Commit".equals(e.getActionCommand())) {
                    if(jcbOperation.getSelectedItem().equals("Store")) {
                        nameStoreAdapter.store(txtID.getText(), txtName.getText());
                    } else if (jcbOperation.getSelectedItem().equals("Read")) {
                        txtName.setText(nameStoreAdapter.read(txtID.getText()));
                    }
                }
            }
        });


        frame.getContentPane().add(lblOperation);
        frame.getContentPane().add(jcbOperation);
        frame.getContentPane().add(lblID);
        frame.getContentPane().add(txtID);
        frame.getContentPane().add(lblName);
        frame.getContentPane().add(txtName);
        frame.getContentPane().add(btnCommit);
        frame.setVisible(true);
    }
}
