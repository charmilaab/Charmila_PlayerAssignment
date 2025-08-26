export const validatePlayer = (player) => {
  const errors = {};
  const nameRegex = /^([A-Z][a-z]+)( [A-Z][a-z]+)*$/;   
  const teamNameRegex = /^[A-Za-z ]{2,30}$/;            
  const stateRegex = /^([A-Z][a-z]+)( [A-Z][a-z]+)*$/;  
  if (!player.name || !nameRegex.test(player.name)) {
    errors.name = "Name must start uppercase, multiple words allowed (e.g., 'MS Dhoni')";
  }
  if (player.jerseyNumber == null || player.jerseyNumber < 1 || player.jerseyNumber > 99) {
    errors.jerseyNumber = "Jersey number must be between 1–99";
  }
  if (!player.role) {
    errors.role = "Select a role";  }
  if (!player.totalMatches || player.totalMatches < 1) {
    errors.totalMatches = "Total matches must be at least 1";  }
  if (!player.teamName || !teamNameRegex.test(player.teamName)) {
    errors.teamName = "Team name must be 2–30 letters/spaces (e.g., 'MI', 'Chennai Super Kings')";  }
  if (!player.state || !stateRegex.test(player.state)) {
    errors.state = "State must start uppercase, multiple words allowed (e.g., 'Tamil Nadu')"; }
  if (!player.description || player.description.trim() === "") {
    errors.description = "Description is mandatory";
  }
  return errors;   };
