package com.hexaware.cricketmanagement.dto;

import com.hexaware.cricketmanagement.entity.Player.Role;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {

    private int id;

    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "[A-Z][a-z]{1,15}", message = "Name must start with uppercase followed by lowercase letters, length 2-16")
    private String name;

    @NotNull(message = "Jersey number is mandatory")
    @Min(value = 1, message = "Jersey number must be at least 1")
    @Max(value = 99, message = "Jersey number must be at most 99")
    private Integer jerseyNumber;

    @NotNull(message = "Role is mandatory")
    private Role role;

    @NotNull(message = "Total matches is mandatory")
    @Min(value = 1, message = "Total matches must be at least 1")
    private Integer totalMatches;

    @NotBlank(message = "Team name is mandatory")
    @Pattern(regexp = "[A-Z]{1,15}[a-z]{1,15}", message = "Team name pattern invalid")
    private String teamName;

    @NotBlank(message = "State is mandatory")
    @Pattern(regexp = "[A-Z][a-z]{1,15}", message = "State must start with uppercase followed by lowercase letters")
    private String state;

	public String getDescription() {
		return null;
	}

    
}
