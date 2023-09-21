# 기능 구현 목록(커밋 단위)

# 다리 생성(BridgeMapMaker)

-[ ] 다리 길이 입력
-[ ] 랜덤 다리 생성(List<String>)
-[ ] BridgeMap 변환(List<MovePosition>)

# MovePosition & InputView

-[ ] 이동할 칸 입력 및 변환("U" | "D" -> MovePosition)
-[ ] 결과에 따라 `MoveResult`에 `SquarePattern` 기록

# GameManager

-[ ] 다리 이동:
 -[ ]: `BridgeMap`에 입력한 `MovePosition` 비교 위임
 -[ ]: `MoveResult`에

# 다리맵(BridgeMap)

-[ ] 데이터 기록(->MoveHistory)
-[ ] 입력한 `MovePosition`과 Map 상의 `MovePosition`이 일치하는지 확인

# SquarePattern(O | X | NONE)

-[ ] 한 칸의 이동 결과를 나타냄

# MoveResult

-[ ] 사용자가 입력한 `SquarePattern` 저장
-[ ] 중간 결과 출력(`List<SquarePattern>`)
-[ ] 최종 결과 출력: 중간 결과 + 게임 성공 여부 + 시도 횟수

