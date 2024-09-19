package team.aliens.dms.domain.volunteer.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateVolunteerWebRequest(

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val content: String,

    @field:Size(min = 1, max = 6)
    @field:NotBlank
    val availableSex: String,

    @field:Size(min = 1, max = 14)
    @field:NotBlank
    val availableGrade: String,

    @field:NotNull
    val score: Int,

    val optionalScore: Int = 0,

    @field:NotNull
    val maxApplicants: Int
)
