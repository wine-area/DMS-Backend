package team.aliens.dms.domain.user.spi

import team.aliens.dms.domain.student.spi.StudentQueryUserPort
import team.aliens.dms.domain.manager.spi.ManagerQueryUserPort
import team.aliens.dms.domain.student.spi.StudentCommandUserPort

interface UserPort : StudentQueryUserPort, ManagerQueryUserPort, StudentCommandUserPort  {
}