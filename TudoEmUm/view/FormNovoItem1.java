/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.legourmet.view;

import br.com.legourmet.dao.ConnectionFactory;
import br.com.legourmet.dao.ItemDAO;
import br.com.legourmet.model.Item;
import java.awt.List;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author gouri
 */
public class FormNovoItem1 extends javax.swing.JFrame {

//    Connection con;
//    Statement st;
//    ResultSet rs;
    // Var para armazenar path da img
    String s = "";
    // var para validar a img
    Boolean imgOK;
    ArrayList<Integer> i = new ArrayList<Integer>();

    /**
     * Creates new form FormNovoItem
     */
    public FormNovoItem1() {
        initComponents();
        //setarChoiceCategoria1();
        setarChoiceCategoria1();
        this.setResizable(false);
        this.setLocationRelativeTo(null);//Tela centralizada
    }

    private void setarChoiceCategoria1() {
        choiceCategoria4.addItem("Sobremesa");
        choiceCategoria4.addItem("Principal");
        choiceCategoria4.addItem("Bebida");
    }

    private void setarChoiceCategoria() {
//        try {
//            con = DriverManager.getConnection("jdbc:mysql://localhost/bd_legourmet", "root", "muy@nupama2");
//            st = con.createStatement();

        ItemDAO dao = new ItemDAO();
        ArrayList<String> bgData;
        // Busca conexao válida
        //Connection conn = ConnectionFactory.getConnection();
        bgData = new ArrayList<String>();
        try {
            bgData = dao.buscarCategorias();
            // SQL que serah executado no BD. Deve estar de acordo com o que
            //foi declarado no BD.
            // As interrogações serão posteriormente substituidas pelos
            //seus respectivos valores
//            String sql = "SELECT categoria FROM itens ";
//            rs = st.executeQuery(sql);
            System.out.println("Categorias obtidas com sucesso");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro " + ex);
            Logger.getLogger(FormNovoItem1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FormNovoItem1.class.getName()).log(Level.SEVERE, null, ex);
        }

//            while (rs.next()) {
//                bgData.add(rs.getString(1));
        int pos = 0;
        while (bgData.size() > i.size()) {
            choiceCategoria4.add(bgData.get(pos).toString());
            i.add(1);
            pos++;
        }
        //}
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "ERROR");
//        }finally{
//            try{
//                st.close();
//                rs.close();
//                con.close();
//            }catch(Exception e){
//                JOptionPane.showMessageDialog(null, "ERROR CLOSE");
//            }
//        }
        //ButtonGroup abDisponivel = new ButtonGroup(){};
        // bgDisponivel4.add(bgData);
        // Busca um objeto associado a conexao que serah posteriormente 
        //disparado para executar o comando SQL.
        //PreparedStatement ps = conn.prepareStatement(sql);
        // Nas linhas abaixo faz a substituicao dos parametros informados
        //no SQL, as interrogacoes (?)
        //ps.setInt(1, id);
        // Dispara o comando p/ o BD
        //ResultSet rs = ps.executeQuery();
        // Verfica se possui registro do BD
//        if (rs.next()) {
//
//            // Cria e abastece o objeto
//            i = new Item();
//
//            i.setId_item(rs.getInt("id_item"));
//            i.setImg_Item(rs.getString("img_item"));
//            i.setNome_Item(rs.getString("nome_item"));
//            i.setCategoria(rs.getString("categoria"));
//            i.setDisponivel(rs.getString("disponivel"));
//            i.setIngredientes(rs.getString("ingredientes"));
//            i.setValor_Item(rs.getDouble("valor_item"));
//            i.setTempo_Preparo_Item(rs.getInt("tempo_preparo_item"));
//
//        }
        // Fechar Conexao
        //return i;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgDisponivel4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnFechar4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtItem4 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtIngredientes4 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jrbDisponivel4 = new javax.swing.JRadioButton();
        jrbIndisponivel4 = new javax.swing.JRadioButton();
        btnSalvar4 = new java.awt.Button();
        btnCancelar4 = new java.awt.Button();
        btnLimpar4 = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtTempoPreparo4 = new javax.swing.JTextField();
        btnAddImg = new java.awt.Button();
        jLabel24 = new javax.swing.JLabel();
        txtValor5 = new javax.swing.JTextField();
        choiceCategoria4 = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(24, 34, 56));

        jPanel2.setBackground(new java.awt.Color(239, 152, 43));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        btnFechar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legourmet/imgs/icons8_Close_Window_25px_2.png"))); // NOI18N
        btnFechar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFechar4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar4)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFechar4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Categoria");

        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Item");

        txtItem4.setBackground(new java.awt.Color(238, 230, 199));
        txtItem4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtItem4.setForeground(new java.awt.Color(24, 34, 56));
        txtItem4.setBorder(null);
        txtItem4.setCaretColor(new java.awt.Color(24, 34, 56));
        txtItem4.setPreferredSize(new java.awt.Dimension(2, 20));
        txtItem4.setSelectionColor(new java.awt.Color(239, 152, 43));

        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Ingredientes:");

        txtIngredientes4.setBackground(new java.awt.Color(238, 230, 199));
        txtIngredientes4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtIngredientes4.setForeground(new java.awt.Color(24, 34, 56));
        txtIngredientes4.setCaretColor(new java.awt.Color(24, 34, 56));
        txtIngredientes4.setSelectionColor(new java.awt.Color(239, 152, 43));
        txtIngredientes4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngredientes4ActionPerformed(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Disponível:");

        jrbDisponivel4.setBackground(new java.awt.Color(24, 34, 56));
        bgDisponivel4.add(jrbDisponivel4);
        jrbDisponivel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jrbDisponivel4.setForeground(new java.awt.Color(255, 255, 255));
        jrbDisponivel4.setSelected(true);
        jrbDisponivel4.setText("Disponível");

        jrbIndisponivel4.setBackground(new java.awt.Color(24, 34, 56));
        bgDisponivel4.add(jrbIndisponivel4);
        jrbIndisponivel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jrbIndisponivel4.setForeground(new java.awt.Color(255, 255, 255));
        jrbIndisponivel4.setText("Indisponível");

        btnSalvar4.setBackground(new java.awt.Color(239, 152, 43));
        btnSalvar4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnSalvar4.setForeground(new java.awt.Color(24, 34, 56));
        btnSalvar4.setLabel("SALVAR");
        btnSalvar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar4ActionPerformed(evt);
            }
        });

        btnCancelar4.setBackground(new java.awt.Color(239, 152, 43));
        btnCancelar4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnCancelar4.setForeground(new java.awt.Color(24, 34, 56));
        btnCancelar4.setLabel("CANCELAR");
        btnCancelar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelar4MouseClicked(evt);
            }
        });

        btnLimpar4.setBackground(new java.awt.Color(239, 152, 43));
        btnLimpar4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnLimpar4.setForeground(new java.awt.Color(24, 34, 56));
        btnLimpar4.setLabel("LIMPAR");
        btnLimpar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Novo Item");

        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Tempo de Preparo (Estimativa)");

        txtTempoPreparo4.setBackground(new java.awt.Color(238, 230, 199));
        txtTempoPreparo4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTempoPreparo4.setForeground(new java.awt.Color(24, 34, 56));
        txtTempoPreparo4.setBorder(null);
        txtTempoPreparo4.setCaretColor(new java.awt.Color(24, 34, 56));
        txtTempoPreparo4.setPreferredSize(new java.awt.Dimension(2, 20));
        txtTempoPreparo4.setSelectionColor(new java.awt.Color(239, 152, 43));

        btnAddImg.setBackground(new java.awt.Color(239, 152, 43));
        btnAddImg.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAddImg.setForeground(new java.awt.Color(24, 34, 56));
        btnAddImg.setLabel("ADICIONAR IMAGEM");
        btnAddImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddImgMouseClicked(evt);
            }
        });
        btnAddImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImgActionPerformed(evt);
            }
        });

        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Valor:");

        txtValor5.setBackground(new java.awt.Color(238, 230, 199));
        txtValor5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtValor5.setForeground(new java.awt.Color(24, 34, 56));
        txtValor5.setBorder(null);
        txtValor5.setCaretColor(new java.awt.Color(24, 34, 56));
        txtValor5.setPreferredSize(new java.awt.Dimension(2, 20));
        txtValor5.setSelectionColor(new java.awt.Color(239, 152, 43));

        choiceCategoria4.setBackground(new java.awt.Color(238, 230, 199));
        choiceCategoria4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        choiceCategoria4.setForeground(new java.awt.Color(24, 34, 56));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel20)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jrbDisponivel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jrbIndisponivel4))
                                .addComponent(txtIngredientes4, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addComponent(jLabel21)
                                .addComponent(txtItem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtTempoPreparo4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(txtValor5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(choiceCategoria4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddImg, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnCancelar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(choiceCategoria4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtItem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIngredientes4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValor5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTempoPreparo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbDisponivel4)
                    .addComponent(jrbIndisponivel4))
                .addGap(38, 38, 38)
                .addComponent(btnAddImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIngredientes4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngredientes4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngredientes4ActionPerformed

    private void btnCancelar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelar4MouseClicked
        int resposta = JOptionPane.showConfirmDialog(null, "Alterações não serão salvas.\nDeseja Realmente sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resposta == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelar4MouseClicked

    private void btnFechar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFechar4MouseClicked
        int resposta = JOptionPane.showConfirmDialog(null, "Alterações não serão salvas.\nDeseja Realmente sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resposta == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnFechar4MouseClicked

    // Métodos jPanel2MouseDragged e jPanel2MousePressed são para mover a tela
    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // src to drag
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    int xx, xy;
    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // drag this pane
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    // Adiciona imagem do item
    private void btnAddImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddImgMouseClicked
        //Abre o Windows Explorer para a pessoa selecionar uma img
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione uma foto");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int opc = fileChooser.showOpenDialog(this);
        if (opc == JFileChooser.APPROVE_OPTION) {
            File file = new File("caminho");
            file = fileChooser.getSelectedFile(); //recebe o path da imagem
            s = file.getAbsolutePath();
        }
//        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
//        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        // Se a img foi recebida...
        if (result == JFileChooser.APPROVE_OPTION) {
            imgOK = true;
            JOptionPane.showMessageDialog(this, "Imagem foi inserida");
//            File selectedFile = fileChooser.getSelectedFile();
//            //Pega o caminho da img
//            String path = selectedFile.getAbsolutePath();
//            //var que envia o path para o btnSalvar4ActionPerformed
//            s = path;

//            label.setIcon(ResizeImage(path)); //Visualiza em tela a img escolhida
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Nenhum arquivo foi escolhido");
        }
    }//GEN-LAST:event_btnAddImgMouseClicked

    private void btnAddImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddImgActionPerformed

    private void btnSalvar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar4ActionPerformed
        Item item = null;

        //Validações
//        if (choiceCategoria4.equals("")) {
//            JOptionPane.showMessageDialog(this, "Categoria Obrigatório!");
//            choiceCategoria4.requestFocus();
//            return;
//        } else 
        if (txtItem4.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Item Obrigatório!");
            txtItem4.requestFocus();
            return;
        } else if (txtIngredientes4.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrediente Obrigatório!");
            txtIngredientes4.requestFocus();
            return;
        } else if (txtValor5.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Valor é Obrigatório!");
            txtIngredientes4.requestFocus();
            return;
        } else if (txtTempoPreparo4.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tempo estimado de preparo é Obrigatório!");
            txtTempoPreparo4.requestFocus();
            return;
        } else if (s.equals("")) {
            JOptionPane.showMessageDialog(this, "Imagem é Obrigatória!");
        } else {
            item = new Item();
        }// Se validações ok --- preenche o objeto item 

        //InputStream recebe Path da imagem
//        File file = new File(s);
//        FileInputStream inputImage;
//        try {
//            inputImage = new FileInputStream(file);
//            InputStream is = inputImage;
        //Insere o path da img no objeto
        item.setImg_Item(s);
        System.out.println("Path recebido com sucesso!");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(FormNovoItem1.class.getName()).log(Level.SEVERE, null, ex);
//        }

        String disponibilidade = null;
        // Obter Disponibilidade do Item
        if (jrbDisponivel4.isSelected()) {
            disponibilidade = jrbDisponivel4.getText();
        }

        if (jrbIndisponivel4.isSelected()) {
            disponibilidade = jrbIndisponivel4.getText();
        }

        //item.setCategoria(choiceCategoria4.getSelectedItem());
        item.setCategoria(choiceCategoria4.getSelectedItem());
        item.setNome_Item(txtItem4.getText());
        item.setIngredientes(txtIngredientes4.getText());
        String valor = txtValor5.getText();
        item.setValor_Item(Double.parseDouble(valor));
        String tempo = txtTempoPreparo4.getText();
        item.setTempo_Preparo_Item(Integer.parseInt(tempo));
        item.setDisponivel(disponibilidade);
        // item.setTempo_Preparo_Item(txtTempoPreparo4.getText());
        //Formata entrada de tempo

        //obtem a entrada em string
        
//        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
//        Date t;
//        try {
//            t = (Date) sdf.parse(tempo);
//            String formattedDate = sdf.format(t);
//            System.out.println(formattedDate);
//        } catch (ParseException ex) {
//            Logger.getLogger(FormNovoItem1.class.getName()).log(Level.SEVERE, null, ex);
//        }
        // Recebe tempo do usuario
        //String tempo_preparo = txtTempoPreparo4.getText();
        // Converte o tempo para date com a formatação
        //String d = sdf.parse(tempo_preparo);
        
        //System.out.println(d.toString());

        try {
            // Chama o DAO para inserir o item no banco
            ItemDAO.inserir(item);
            JOptionPane.showMessageDialog(this,
                    "Dados salvos com sucesso!");
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(FormNovoItem1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex, "Erro", HEIGHT);
        }
    }//GEN-LAST:event_btnSalvar4ActionPerformed

    private void btnLimpar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar4ActionPerformed
        //Set vázio nos campos
//        txtCodigo4.setText("");
        txtIngredientes4.setText("");
        txtItem4.setText("");
        txtTempoPreparo4.setText("");

        //Foca na variável
        txtItem4.requestFocus();
        return; // Nao processa restante do codigo
    }//GEN-LAST:event_btnLimpar4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormNovoItem1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNovoItem1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNovoItem1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNovoItem1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNovoItem1().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgDisponivel4;
    private java.awt.Button btnAddImg;
    private java.awt.Button btnCancelar4;
    private javax.swing.JLabel btnFechar4;
    private java.awt.Button btnLimpar4;
    private java.awt.Button btnSalvar4;
    private java.awt.Choice choiceCategoria4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jrbDisponivel4;
    private javax.swing.JRadioButton jrbIndisponivel4;
    private javax.swing.JTextField txtIngredientes4;
    private javax.swing.JTextField txtItem4;
    private javax.swing.JTextField txtTempoPreparo4;
    private javax.swing.JTextField txtValor5;
    // End of variables declaration//GEN-END:variables
}
