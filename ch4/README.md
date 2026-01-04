# Chapter 4 Challenge: Personal Diary Manager - JavaFX GUI Version

This project is a personal diary manager with a graphical user interface built using JavaFX. It allows users to create, save, delete, and search for diary entries. The application features a rich text editor, theme support (light and dark modes), and a responsive user interface.

## How to Run the Application

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    ```
2.  **Open the project in your favorite IDE.**
3.  **Run the `DiaryManagerApp` class.**

## Design Choices

*   **JavaFX:** I chose JavaFX for its modern UI components and rich set of features, which are well-suited for creating a desktop application like a diary manager.
*   **FXML:** The UI is defined in an FXML file, which separates the presentation layer from the application logic. This makes the code cleaner and easier to maintain.
*   **CSS Styling:** The application uses CSS for styling, allowing for easy customization of the look and feel. It includes separate stylesheets for light and dark themes.
*   **`java.nio.file` API:** I used the modern `java.nio.file` API for file operations. This API provides a more powerful and flexible way to work with files compared to the older `java.io.File` class.
*   **Concurrency:** File operations are performed on a background thread using `javafx.concurrent.Task` to prevent the UI from freezing. A `ProgressIndicator` is displayed to provide visual feedback to the user during these operations.
*   **Rich Text Editing:** The application uses an `HTMLEditor` to provide rich text editing capabilities. Diary entries are saved as HTML files to preserve the formatting.
*   **Error Handling:** The application includes user-friendly error dialogs to provide feedback to the user in case of errors during file operations.

## How to Use the Application

*   **Create a new entry:** Click on the "New Entry" menu item in the "File" menu.
*   **Save an entry:** Write your diary entry in the rich text editor and click on the "Save Entry" menu item in the "File" menu.
*   **Delete an entry:** Select an entry from the list on the left and click on the "Delete Entry" menu item in the "File" menu.
*   **Search for entries:** Type a search term in the search field and click the "Search" button. The list of entries will be filtered to show only the entries that contain the search term.
*   **Switch themes:** Use the "Light Mode" and "Dark Mode" menu items in the "Theme" menu to switch between the light and dark themes.
