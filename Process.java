class SystemCommandRunner {
    public static void runCommand() {
        System.out.println("🚀 Starting system command in a separate process...\n");
        
        try {
            String[] command = {"cmd", "/c", "dir"};
            Process fileListProcess = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(fileListProcess.getInputStream())
            );
            
            String line;
            System.out.println("📁 Files in current directory:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            int exitCode = fileListProcess.waitFor();
            System.out.println("\n✅ Process finished with exit code: " + exitCode);
            
        } catch (Exception error) {
            System.out.println("❌ Something went wrong: " + error.getMessage());
        }
    }
}
