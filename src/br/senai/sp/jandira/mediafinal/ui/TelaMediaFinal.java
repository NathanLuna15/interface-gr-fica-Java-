package br.senai.sp.jandira.mediafinal.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class TelaMediaFinal extends Application {

    VBox painelResultado;
    TextField tfNomeAluno;
    TextField tfNome1;
    TextField tfNome2;
    TextField tfNome3;
    TextField tfNome4;
    Label lblNome;
    Label lblNota1 ;
    Label lblNota2;
    Label lblNota3;
    Label lblNota4;

    @Override
    public void start(Stage stage) throws Exception {
       //comfiguração da tela
        stage.setWidth(600);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.setTitle("Media do aluno");

        //painel primcipal (root)
        BorderPane root = new BorderPane();

        //criar o label com o titulo da tela
        Label titulo = new Label();
        titulo.setText("Escola SENAI \"prof. vicente Amato\"");
        titulo.setStyle("-fx-font-size: 22; -fx-text-fill:white");
        titulo.setPadding(new Insets(10, 0, 10, 10));


        //painel superior
        HBox painelSuperior = new HBox();
        painelSuperior.getChildren().addAll(titulo);
        painelSuperior.setStyle("-fx-background-color: #1a58c9");

        //formulario
        VBox painelFormulario = new VBox();
        painelFormulario.setPadding(new Insets(10, 20, 10, 10));
         lblNome = new Label("Nome do aluno");
         lblNota1 = new Label("Nota 1");
         lblNota2 = new Label("Nota 2");
         lblNota3 = new Label("Nota 3");
         lblNota4 = new Label("Nota 4");
         tfNomeAluno = new TextField();
         tfNome1 = new TextField();
         tfNome2 = new TextField();
         tfNome3 = new TextField();
         tfNome4 = new TextField();

        painelFormulario.getChildren().addAll(
                lblNome,tfNomeAluno,
                lblNota1,tfNome1,
                lblNota2,tfNome2,
                lblNota3,tfNome3,
                lblNota4,tfNome4
        );

        //Botão
        VBox painelBotao = new VBox();
        painelBotao.setStyle("-fx-background-color: #1a58c9");
        painelBotao.setPadding(new Insets(10));
        painelBotao.setSpacing(15);
        Button btCaucularMedia = new Button("calcular media");
        btCaucularMedia.setPrefWidth(150);
        btCaucularMedia.setPrefHeight(70);
        Button btLimpar = new Button("Linpar");
        btLimpar.setPrefWidth(150);
        btLimpar.setPrefHeight(70);
         Button btSair = new Button("Sair");
         btSair.setPrefWidth(150);
         btSair.setPrefHeight(70);
         painelBotao.getChildren().addAll(
                 btCaucularMedia,
                 btLimpar,
                 btSair
         );

         //Resultado
         painelResultado = new VBox();
         painelResultado.setPadding(new Insets(10, 20, 10, 10));
         painelResultado.setStyle("-fx-background-color: #386dcf");
         Label lblResultado = new Label("Resultado: ");
         lblResultado.setStyle("-fx-font-size: 22; -fx-text-fill:white; fx-font-weight: bold");
         Label lblNomeResultado = new Label("Nome do aluno: ");
         lblNomeResultado.setStyle("-fx-text-fill:white");
         Label lblMedia = new Label("Media final:");
         lblMedia.setStyle("-fx-text-fill:white");
         Label lblsituacao = new Label("Situação: ");
         lblsituacao.setStyle("-fx-text-fill:white");
         painelResultado.getChildren().addAll(
                 lblResultado,
                 lblNomeResultado,
                 lblMedia,
                 lblsituacao
         );





        root.setTop(painelSuperior);
        root.setCenter(painelFormulario);
        root.setRight(painelBotao);
        root.setBottom(painelResultado);


        //obijeto cena
        Scene scene = new Scene(root);

        stage.setScene(scene);


        stage.show();

        //intersepitar cliques nos baotoes
        btCaucularMedia.setOnAction(e -> {
            if(ValidarEntrada()){

                String NomeAluno = tfNomeAluno.getText();
                lblNomeResultado.setText("Nome do aluno: " + NomeAluno);
                System.out.println("NomeAluno: " + NomeAluno);

                String Nota1 = tfNome1.getText();
                String Nota2 = tfNome2.getText();
                String Nota3 = tfNome3.getText();
                String Nota4 = tfNome4.getText();

                double media = calcularMedia(Nota1, Nota2, Nota3, Nota4);
                lblMedia.setText("Media final: " + media);

                String situacao = DefinirCituacao(media);
                String mediaFormatada = String.format("%.2f", media);
                lblsituacao.setText("Situação: " + mediaFormatada);
            }
        });



        btLimpar.setOnAction(e -> {
            tfNomeAluno.setText("");
            tfNome1.setText("");
            tfNome2.setText("");
            tfNome3.setText("");
            tfNome4.setText("");
            lblNomeResultado.setText("Nome do aluno: ");
            lblMedia.setText("Media final: ");
            lblsituacao.setText("Situação:");
            painelResultado.setStyle("-fx-background-color: #1a58c9");
        });

        btSair.setOnAction(e -> {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Sair do programa?", ButtonType.YES, ButtonType.NO);
         Optional<ButtonType> resposta = alert.showAndWait();

        if (resposta.get() == ButtonType.YES) {
            System.exit(0);
        }
        });

    }

    private double calcularMedia(String n1, String n2, String n3, String n4) {
        double nota1 = Double.parseDouble(n1);
        double nota2 = Double.parseDouble(n2);
        double nota3 = Double.parseDouble(n3);
        double nota4 = Double.parseDouble(n4);
        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        return media;
    }



    private String DefinirCituacao(double media) {
        if (media < 4) {
            painelResultado.setStyle("-fx-background-color: #d91010");
            return "Reprovado";
        } else if (media >= 6) {
            painelResultado.setStyle("-fx-background-color: #1ac929");
            return "Aprovado";
        } else {
            painelResultado.setStyle("-fx-background-color: #d6540d");
            return "Recuperação";
        }

    }
    private  boolean ValidarEntrada(){
        if (tfNomeAluno.getText().isEmpty()){
            MostrarMensagem(Alert.AlertType.ERROR, "preencha o nome do aluno!");
            tfNomeAluno.requestFocus();
            return false;
        }else if(lblNota1.getText().isEmpty()){
            MostrarMensagem(Alert.AlertType.ERROR, "preencha nota1 do aluno!");
            lblNota1.requestFocus();
            return false;
        }else if (lblNota2.getText().isEmpty()){
            MostrarMensagem(Alert.AlertType.ERROR, "preencha nota2 do aluno!");
            lblNota2.requestFocus();
            return false;
        }else if (lblNota3.getText().isEmpty()){
            MostrarMensagem(Alert.AlertType.ERROR, "preencha nota3 do aluno!");
            lblNota3.requestFocus();
            return false;
        } else if (lblNota4.getText().isEmpty()) {
            MostrarMensagem(Alert.AlertType.ERROR, "preencha nota4 do aluno!");
            lblNota4.requestFocus();
            return false;
        }
        return true;
    }

    private void MostrarMensagem(Alert.AlertType tipo, String mensagem){
        Alert alert = new Alert(tipo, mensagem);
        alert.showAndWait();
    }

}
