package Ex3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

// Gère l'interface graphique et la communication réseau du client
public class ClientChatGUI {

    // Composants de l'interface graphique
    private JFrame frame;
    private JTextArea textArea;
    private JTextField textField;
    private JButton sendButton;

    // Flux de communication réseau
    private PrintWriter out;
    private BufferedReader in;
    private String pseudo;

    public ClientChatGUI(String serveur, int port) {
        initGUI(); // Construit la fenêtre en premier
        connectToServer(serveur, port); // Établit la connexion
        startMessageListener(); // Lance l'écoute en arrière-plan
    }

    private void initGUI() {
        // Configuration de la fenêtre principale
        frame = new JFrame("Chat Client");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Zone d'affichage des messages (non modifiable par l'utilisateur)
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        textField = new JTextField();
        sendButton = new JButton("Envoyer");

        // Regroupe le champ de texte et le bouton en bas de la fenêtre
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(textField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(panel, BorderLayout.SOUTH);

        // Action commune pour l'envoi (clic sur le bouton ou touche "Entrée")
        ActionListener sendAction = e -> sendMessage();
        sendButton.addActionListener(sendAction);
        textField.addActionListener(sendAction);

        frame.setVisible(true);

        // Boîte de dialogue bloquante pour demander le pseudo au lancement
        pseudo = JOptionPane.showInputDialog(frame, "Entrez votre pseudo :");
        if (pseudo == null || pseudo.isEmpty()) pseudo = "Anonyme";
    }

    private void connectToServer(String serveur, int port) {
        try {
            // Établit la connexion et initialise les flux
            Socket socket = new Socket(serveur, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Envoie immédiatement le pseudo pour l'identification côté serveur
            out.println(pseudo);

        } catch (IOException e) {
            // Affiche une alerte visuelle si le serveur est injoignable
            JOptionPane.showMessageDialog(frame, "Impossible de se connecter au serveur",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    private void startMessageListener() {
        // Un thread dédié est indispensable pour ne pas bloquer l'interface graphique
        Thread listener = new Thread(() -> {
            String message;
            try {
                // Écoute en boucle et ajoute chaque message reçu dans la zone de texte
                while ((message = in.readLine()) != null) {
                    textArea.append(message + "\n");
                }
            } catch (IOException e) {
                textArea.append("Connexion au serveur perdue\n");
            }
        });
        listener.start();
    }

    private void sendMessage() {
        String msg = textField.getText().trim();
        // Vérifie que le message n'est pas vide avant de l'envoyer
        if (!msg.isEmpty()) {
            out.println(msg);
            textField.setText(""); // Vide le champ de saisie après l'envoi
        }
    }

    public static void main(String[] args) {
        String serveur = "localhost";
        int port = 5000;

        // Lance la création de l'interface graphique sur l'Event Dispatch Thread (EDT) de Swing
        SwingUtilities.invokeLater(() -> new ClientChatGUI(serveur, port));
    }
}