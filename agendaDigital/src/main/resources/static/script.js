const baseUrl = "/api/clientes";

const getValue = id => document.getElementById(id)?.value;

const clienteFromForm = () => ({
    nome: getValue("nome"),
    cpf: getValue("cpf"),
    endereco: getValue("endereco"),
    dataNascimento: getValue("dataNascimento")
});

const clienteUpdate = () => ({
    nome: getValue("nome"),
    endereco: getValue("endereco"),
    dataNascimento: getValue("dataNascimento")
});

const handleResponse = (res, successMsg, errorMsg) => {
    if (res.ok) alert(successMsg);
    else alert(errorMsg);
};


document.querySelector("button")?.addEventListener("click", () => {
    if (!document.getElementById("cpf")) return; // só roda no index.html

    fetch(`${baseUrl}/create`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(clienteFromForm())
    }).then(res => handleResponse(res, "Cliente cadastrado!", "Erro ao cadastrar."));
});

document.querySelector("button:nth-of-type(3)")?.addEventListener("click", () => {
    fetch(`${baseUrl}/findAll`)
        .then(res => res.json())
        .then(data => {
            if (data.length === 0) {
                document.getElementById("resultado").innerText = "Nenhum cliente cadastrado.";
                return;
            }


            const lista = data.map((c, i) =>
                `${i + 1} - ${c.nome} | ${c.cpf} | ${c.endereco} | ${c.dataNascimento}`
            ).join("\n");

            document.getElementById("resultado").innerText = lista;
        })
        .catch(() => {
            document.getElementById("resultado").innerText = "Erro ao buscar clientes.";
        });
});


document.querySelector(".update")?.addEventListener("click", () => {
    if (!document.getElementById("search")) return;

    const termo = getValue("search");

    fetch(`${baseUrl}?nome=${termo}&cpf=${termo}`)
        .then(res => res.json())
        .then(data => {
            if (data.length > 0) {
                const cliente = data[0];
                document.getElementById("resultado").innerText =
                    `Nome: ${cliente.nome}\nCPF: ${cliente.cpf}\nEndereço: ${cliente.endereco}\nNascimento: ${cliente.dataNascimento}`;
            } else {
                document.getElementById("resultado").innerText = "Cliente não encontrado.";
            }
        })
        .catch(() => {
            document.getElementById("resultado").innerText = "Erro na busca.";
        });
});

document.querySelector(".updateCliente")?.addEventListener("click", () => {
    const id = getValue("idAtualiza");
    if (!id) return alert("Informe o ID do cliente!");

    fetch(`${baseUrl}/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(clienteUpdate())
    }).then(res => handleResponse(res, "Cliente atualizado com sucesso!", "Erro ao atualizar cliente."));
});

document.querySelector(".delete")?.addEventListener("click", () => {
    const id = getValue("idDelete");
    if (!id) return alert("Informe o ID do cliente para deletar!");

    fetch(`${baseUrl}/${id}`, { method: "DELETE" })
        .then(res => handleResponse(res, "Cliente deletado!", "Erro ao deletar."));
});
