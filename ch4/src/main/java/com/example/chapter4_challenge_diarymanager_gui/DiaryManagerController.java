package com.example.chapter4_challenge_diarymanager_gui;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DiaryManagerController {

    @FXML
    private TextField searchField;

    @FXML
    private ListView<String> entryListView;

    @FXML
    private HTMLEditor entryHTMLEditor;

    @FXML
    private ProgressIndicator progressIndicator;

    private final Path diaryEntriesDir = Paths.get("diary_entries");

    @FXML
    public void initialize() {
        createDiaryEntriesDirectory();
        loadEntries();
        entryListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                loadEntryContent(newValue);
            }
        });
    }

    private void createDiaryEntriesDirectory() {
        if (!Files.exists(diaryEntriesDir)) {
            try {
                Files.createDirectories(diaryEntriesDir);
            } catch (IOException e) {
                showErrorDialog("Error creating diary directory", e.getMessage());
            }
        }
    }

    private void loadEntries() {
        executeTask(() -> {
            entryListView.getItems().clear();
            try (Stream<Path> paths = Files.list(diaryEntriesDir)) {
                paths.filter(Files::isRegularFile)
                        .map(path -> path.getFileName().toString())
                        .forEach(entryListView.getItems()::add);
            } catch (IOException e) {
                showErrorDialog("Error loading entries", e.getMessage());
            }
        });
    }

    private void loadEntryContent(String entryName) {
        executeTask(() -> {
            try {
                String content = Files.readString(diaryEntriesDir.resolve(entryName));
                entryHTMLEditor.setHtmlText(content);
            } catch (IOException e) {
                showErrorDialog("Error loading entry", e.getMessage());
            }
        });
    }

    @FXML
    private void handleNewEntry() {
        entryListView.getSelectionModel().clearSelection();
        entryHTMLEditor.setHtmlText("");
        entryHTMLEditor.requestFocus();
    }

    @FXML
    private void handleSaveEntry() {
        String content = entryHTMLEditor.getHtmlText();
        if (content.isEmpty()) {
            showErrorDialog("Cannot save empty entry", "Please write something before saving.");
            return;
        }
        String selectedEntry = entryListView.getSelectionModel().getSelectedItem();
        if (selectedEntry == null) {
            String title = "entry_" + System.currentTimeMillis() + ".html";
            saveEntryToFile(title, content);
            entryListView.getItems().add(title);
        } else {
            saveEntryToFile(selectedEntry, content);
        }
    }

    private void saveEntryToFile(String fileName, String content) {
        executeTask(() -> {
            try {
                Files.writeString(diaryEntriesDir.resolve(fileName), content);
            } catch (IOException e) {
                showErrorDialog("Error saving entry", e.getMessage());
            }
        });
    }

    @FXML
    private void handleDeleteEntry() {
        String selectedEntry = entryListView.getSelectionModel().getSelectedItem();
        if (selectedEntry != null) {
            executeTask(() -> {
                try {
                    Files.deleteIfExists(diaryEntriesDir.resolve(selectedEntry));
                    entryListView.getItems().remove(selectedEntry);
                    entryHTMLEditor.setHtmlText("");
                } catch (IOException e) {
                    showErrorDialog("Error deleting entry", e.getMessage());
                }
            });
        }
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleLightTheme() {
        entryHTMLEditor.getScene().getStylesheets().remove(getClass().getResource("dark-theme.css").toExternalForm());
        entryHTMLEditor.getScene().getStylesheets().add(getClass().getResource("light-theme.css").toExternalForm());
    }

    @FXML
    private void handleDarkMode() {
        entryHTMLEditor.getScene().getStylesheets().remove(getClass().getResource("light-theme.css").toExternalForm());
        entryHTMLEditor.getScene().getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
    }

    @FXML
    private void handleSearch() {
        String searchTerm = searchField.getText();
        if (searchTerm.isEmpty()) {
            loadEntries();
            return;
        }
        executeTask(() -> {
            entryListView.getItems().clear();
            try (Stream<Path> paths = Files.list(diaryEntriesDir)) {
                paths.filter(Files::isRegularFile)
                        .filter(path -> {
                            try {
                                return Files.readString(path).toLowerCase().contains(searchTerm.toLowerCase());
                            } catch (IOException e) {
                                return false;
                            }
                        })
                        .map(path -> path.getFileName().toString())
                        .forEach(entryListView.getItems()::add);
            } catch (IOException e) {
                showErrorDialog("Error during search", e.getMessage());
            }
        });
    }

    private void executeTask(Runnable taskRunnable) {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() {
                taskRunnable.run();
                return null;
            }
        };
        progressIndicator.visibleProperty().bind(task.runningProperty());
        new Thread(task).start();
    }

    private void showErrorDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
