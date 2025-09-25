const baseUrl = "/api/contatos";

const getValue = id => document.getElementById(id)?.value;

const contatoFromForm = () => ({
    tipo: getValue("tipo"),
    valor: getValue("valor"),
    observacao: getValue("observacao")
});

const contatoUpdateFromForm = () => ({
    tipo: getValue("tipoUpdate"),
    valor: getValue("valorUpdate"),
    observacao: getValue("observacaoUpdate")
});

const handleResponse = (res, successMsg, errorMsg) => {
    if (res.ok) alert(successMsg);
    else alert(errorMsg);
};

document.getElementById("btn-cadastrar").addEventListener("click", () => {
    const clienteId = document.getElementById("clienteId").value;
    fetch(`${baseUrl}/create/${clienteId}`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(contatoFromForm())
    }).then(res => handleResponse(res, "Contato cadastrado!", "Erro ao cadastrar o contato."));
});

document.querySelector(".idContato").addEventListener("click", () => {
    const clienteId = document.getElementById("search").value;

    fetch(`${baseUrl}/${clienteId}`)
        .then(res => res.json())
        .then(data => {
            if (!data.length) {
                document.getElementById("resultado").innerText = "Nenhum contato encontrado.";
                return;
            }

            const texto = data.map(c =>
                `Cliente: ${c.cliente.nome} CPF:(${c.cliente.cpf})
Endereço: ${c.cliente.endereco}
Nascimento: ${c.cliente.dataNascimento}
Contato: ${c.tipo} - ${c.valor}
Observação: ${c.observacao ?? "Nenhuma"}`
            ).join("\n\n");

            document.getElementById("resultado").innerText = texto;
        })
        .catch(() => {
            document.getElementById("resultado").innerText = "Erro ao buscar contatos.";
        });
});

document.querySelector(".updateContato")?.addEventListener("click", () => {
    const id = getValue("idContato");
    if (!id) return alert("Informe o ID do contato!");

    fetch(`${baseUrl}/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(contatoUpdateFromForm())
    }).then(res => handleResponse(res, "Contato atualizado com sucesso!", "Erro ao atualizar contato."));
});

document.querySelector(".deleteId")?.addEventListener("click", () => {
    const id = getValue("delete");
    if (!id) return alert("Informe o ID correto do contato para deletar!");

    fetch(`${baseUrl}/${id}`, { method: "DELETE" })
        .then(res => handleResponse(res, "Contato deletado!", "Erro ao deletar."));
});