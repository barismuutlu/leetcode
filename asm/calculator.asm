DEFAULT REL
SECTION .data
	str1 db "Wählen Sie die gewünschte Operation aus: 1 - Addition 2 - Subtraktion 3 - Multiplikation 4 - Division ", 0
	str2 db "Erste Operand:", 0
	str3 db "Zweite Operand:", 0
	int_input db "%d", 0
	error_msg db "Error!", 0
SECTION .bss
	operand1 resq 1
	operand2 resq 1
	operation resq 1
SECTION .text
        global main
        extern printf
        extern scanf
ALIGN 8
main:
        push rbx

	mov rdi, str1
	xor rsi, rsi
	call printf

	mov rdi, int_input
	mov rsi, operation
	call scanf


	mov rdi, str2
	xor rsi, rsi
	call printf

	mov rdi, int_input
	mov rsi, operand1
	call scanf

	mov rdi, str3
	xor rsi, rsi
	call printf

	mov rdi, int_input
	mov rsi, operand2
	call scanf

	mov rax, [operand1]
	mov rbx, [operand2]

	mov rcx, [operation]
	cmp rcx, 1
	je addition
	cmp rcx, 2
	je subtraktion
	cmp rcx, 3
	je multiplikation
	cmp rcx, 4
	je division


addition:
	add rax, rbx
	jmp so
subtraktion:
	sub rax, rbx
	jmp so
multiplikation:
	imul rax, rbx
	jmp so

division:
    cmp rbx, 0         ; Bölen 0 mı?
    je error_division  ; Eğer sıfırsa hata mesajına git

    cqo             ; EDX:EAX oluştur (işaret genişletme)
    idiv rbx           ; EAX = EAX / EBX, EDX = Kalan
    jmp so   ; Sonucu yazdır

error_division:
    mov rdi, error_msg
    call printf




so:
	mov rdi, int_input
	mov rsi, rax
	call printf


        pop rbx
        mov rax, 0
        ret
