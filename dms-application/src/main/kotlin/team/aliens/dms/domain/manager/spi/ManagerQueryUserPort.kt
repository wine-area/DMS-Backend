package team.aliens.dms.domain.manager.spi

import team.aliens.dms.domain.manager.dto.Sort
import team.aliens.dms.domain.user.model.User
import java.util.UUID

interface ManagerQueryUserPort {

    fun queryUserById(userId: UUID): User?

    fun queryUserBySchoolId(schoolId: UUID): User?

    fun queryUserByAccountId(accountId: String): User?

    fun queryUserByEmail(email: String): User?

    fun searchStudent(name: String, sort: Sort): List<User>
    
    fun queryUserByRoomNumberAndSchoolId(roomNumber: Int, schoolId: UUID): List<User>

}